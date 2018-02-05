<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<style type="text/css">
	h1 {
		width: 100px;
		height: 40px;
		margin: 0 auto;
	}
	.animalImg {
		width: 700px;
		height: 150px;
		margin: 0 auto;
	}
	.homeimg {
		width : 150px;
		height: 150px;
	}
</style>
	<title>HOME</title>
</head>
<body>
	<div class="container">
		<h1>HOME</h1>
		<div class="animalImg">
			<img alt="pig" class="homeimg" src="${pageContext.request.contextPath}/resources/img/pig.png">
			<img alt="monkey" class="homeimg" src="${pageContext.request.contextPath}/resources/img/monkey.png">
			<img alt="sheep" class="homeimg" src="${pageContext.request.contextPath}/resources/img/sheep.png">
			<img alt="snake" class="homeimg" src="${pageContext.request.contextPath}/resources/img/snake.png">
		</div>
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
