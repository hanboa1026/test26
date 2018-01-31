<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>city List</title>
</head>
<body>
<div class="container">
	<h2>city List</h2>
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