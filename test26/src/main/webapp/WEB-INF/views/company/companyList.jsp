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
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
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
		<div class="col-lg-7 col-sm-6">
		<!-- company add -->
			<a href="${pageContext.request.contextPath}/company/companyInsert"
				class="btn btn-warning"><i class="fas fa-plus-circle"></i></a>
		</div>
		
			<form action="${pageContext.request.contextPath}/company/companyList" method="POST" class="col-lg-3 col-sm-3 form-inline">
				<div class="input-group">
				<input class="form-control" type="text" name="keyword">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit" value="검색"><i class="fas fa-search"></i></button>
				</div>
				</div>
			</form>
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
								class="fas fa-pencil-alt"></i></a></td>
						<td><a class="btn btn-danger"
							href="${pageContext.request.contextPath}/company/companyDelete?companyId=${company.companyId}"><i
								class="fa fa-trash"></i></a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="clearfix"></div>
			<ul class="pagination pull-right">
			<c:if test="${currentPage!=1}">
				<li class="previous"><a href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage-1}"><i class="fas fa-chevron-left"></i></a></li>
			</c:if>

			<c:if test="${ currentpage != lastPage}">
				<li class="next"><a href="${pageContext.request.contextPath}/company/companyList?currentPage=${currentPage+1}"><i class="fas fa-chevron-right"></i></a></li>
			</c:if>
			</ul>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	
</body>

</html>