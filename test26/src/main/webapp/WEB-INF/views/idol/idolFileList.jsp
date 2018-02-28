<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

<title>Idol File List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>Country&nbsp;File&nbsp;List</h1>
			</div>
		</div>
		<div class="row">
				<div class="col-lg-2 col-sm-4">
				<a class="homeicon"
					href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i></a>
				</div>
				<div class="col-lg-2 col-sm-2">
				<a href="${pageContext.request.contextPath}/idolAdd" class="btn btn-info"><i class="fas fa-plus-square"></i></a>
				</div>
				<div class="col-lg-8 col-sm-6 form-inline">
				<form action="${pageContext.request.contextPath}/idol/idolList" method="post">
					<select name="searchOption" class="form-control">
					<!-- 검색 조건을 검색 처리후 결과화명에 보여주기 위해 c:out 출력체크 사용(삼합연산자) -->
					<option value="all"<c:out value=${searcOption=='all'?'selected':''}"/>>전체보기</option>
					<%-- <option value="country_name" <c:out value="${searchOption == 'country_name'?'selected':''}"/>>이름</option> --%>
					</select>
					<input name="keyword" value="${keyword}" class="form-control" placeholder="Search">
					<button class="btn btn-info" type="submit" value="검색"><i class="fas fa-search"></i></button>
				</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-2">
					<jsp:include page="/WEB-INF/views/inc/left.jsp"></jsp:include>
				</div>
				<div class="col-lg-10">
					<table class="table table-striped table-hover">
					<thead>
						<tr class="success">
							<th>No.</th>
							<th>NAME</th>
							<th>EXT</th>
							<th>SIZE</th>
						</tr>
					</thead>
					<c:forEach var="idolFile" items="${idoCommandFile.list}">
						<tbody>
							<tr>
								<td>${idolFile.idolFileId}</td>
								<td>${idolFile.fileName}</td>
								<td>${idolFile.fileExt}</td>
								<td>${idolFile.fileSize}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
					<ul>
					<c:if test="${currentPage > 1}">
						<li class="previous"><a href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage-1}">Previous</a></li>
					</c:if>
					<c:if test="${currentPage < lastPage}">
						<li class="next"><a href="${pageContext.request.contextPath}/idol/idolList?currentpage=${currentPage+1}">Next</a></li>
					</c:if>
					</ul>
				</div>
			</div>
		</div>
			<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>

</body>
</html>