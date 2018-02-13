<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Company List</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>Company&nbsp;List</h1>
			</div>
		</div>
		<div class="row">
		<div class="col-lg-2 col-sm-3">
			<a class="col-lg-9 col-sm-9 homeicon"
				href="${pageContext.request.contextPath}/"><img alt="home"
				src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<div class="col-lg-10 col-sm-9">
			<a href="${pageContext.request.contextPath}/company/companyInsert"
				class="btn btn-warning">ADD</a>
				<form action="${pageContext.request.contextPath}/company/companyList" method="POST">
				<select name="searchOption">
					<option value="companyNo">회사NO</option>
					<option value="companyName">회사이름</option>
				</select>
				<input type="text" name="keyword">
				<input type="submit" value="검색">
				</form>
				
		</div>
	</div>
	<div class="row">
		<div class="col-lg-2">
			<jsp:include page="/WEB-INF/views/inc/left.jsp"></jsp:include>
		</div>
		<div class="col-lg-10">
			<table class="table table-striped table-hover">
				<tr class="warning">
					<th>No.</th>
					<th>NAME</th>
					<th>UPDATE</th>
					<th>DELETE</th>
				</tr>
				<c:forEach var="company" items="${Companylist}">
					<tr>
						<td>${company.companyId}</td>
						<td>${company.companyName}</td>
						<td><a class="btn btn-primary"
							href="${pageContext.request.contextPath}/company/companyUpdate?companyId=${company.companyId}"><i
								class="fa fa-pencil"></i></a></td>
						<td><a class="btn btn-danger"
							href="${pageContext.request.contextPath}/company/companyDelete?companyId=${company.companyId}"><i
								class="fa fa-trash"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<c:if test="${currentPage!=1}">
				<a
					href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage-1}">이전</a>
			</c:if>

			<c:if test="${ currentpage != lastPage}">
				<a
					href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage+1}">다음</a>
			</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	
</body>

</html>