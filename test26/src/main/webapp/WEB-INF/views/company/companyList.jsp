<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<title>Company List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-3 col-sm-3">Company List</h2>
			<a class="col-lg-9 col-sm-9 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<a href="${pageContext.request.contextPath}/company/companyInsertForm" class="btn btn-warning">ADD</a>
		<table class="table table-striped table-hover">
			<tr class="warning">
				<th>No.</th>
				<th>NAME</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
			<c:forEach var="company" items="${list}">
			<tr>
				<td>${company.companyId}</td>
				<td>${company.companyName}</td>
				<td><a href="${pageContext.request.contextPath}/company/companyUpdate?companyId=${company.companyId}">Edit</a></td>
				<td><a href="${pageContext.request.contextPath}/company/companyDelete?companyId=${company.companyId}">Remove</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>