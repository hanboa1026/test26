<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2">Country Insert</h2>
			<a class="col-lg-10 homeicon"
				href="${pageContext.request.contextPath}/"><img alt="home"
				src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="addCountry" method="post"
			action="${pageContext.request.contextPath}/countryAdd">
			CountryName:<input name="countryName" type="text">
			<button type="submit">ADD</button>
		</form>
	</div>
</body>
</html>