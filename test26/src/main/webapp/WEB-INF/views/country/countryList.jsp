<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<title>Country List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2 col-sm-3">Country List</h2>
			<a class="col-lg-10 col-sm-9 homeicon"
				href="${pageContext.request.contextPath}/"><img alt="home"
				src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<a href="${pageContext.request.contextPath}/countryAdd" class="btn btn-success">ADD</a>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="success">
					<th>No.</th>
					<th>NAME</th>
					<th>UPDATE</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<c:forEach var="country" items="${list}">
				<tbody>
					<tr>
						<td>${country.countryId}</td>
						<td>${country.countryName}</td>
						<td><a
							href="${pageContext.request.contextPath}/countryModify?countryId=${country.countryId}">수정</a></td>
						<td><a
							href="${pageContext.request.contextPath}/countryRemove?countryId=${country.countryId}">삭제</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>