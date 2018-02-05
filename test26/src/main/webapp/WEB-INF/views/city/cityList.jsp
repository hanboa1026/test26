<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<style type="text/css">
	.homeicon {
		padding-top: 12px;
	}
</style>
<title>city List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2">city List</h2>
			<a class="col-lg-10 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>넘버</th>
					<th>나라명</th>
				</tr>
			</thead>
			<c:forEach var="city" items="${list}">
			<tbody>
				<tr>
					<td>${city.cityId}</td>
					<td>${city.cityName}</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>	
</body>
</html>