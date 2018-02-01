<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<title>HOME</title>
</head>
<body>
<div class="container">
<h1>HOME</h1>
	<ul class="list-group">
		<li class="list-group-item"><a class="btn btn-danger btn-lg btn-block" href="${pageContext.request.contextPath}/book/bookList">책 목록</a></li>
		<li class="list-group-item"><a class="btn btn-warning btn-lg btn-block" href="${pageContext.request.contextPath}/company/companyList">회사 목록</a></li>
		<li class="list-group-item"><a class="btn btn-success btn-lg btn-block" href="${pageContext.request.contextPath}/country/countryList">나라 목록</a></li>
		<li class="list-group-item"><a class="btn btn-info btn-lg btn-block" href="${pageContext.request.contextPath}/idol/idolList">아이돌 목록</a></li>
		<li class="list-group-item"><a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/city/cityList">도시 목록</a></li>
	</ul>
</div>
</body>
</html>
