<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Left</title>
</head>
<body>
	<ul class="list-group">
		<li class="list-group-item"><a class="btn btn-danger btn-lg btn-block" 
			href="${pageContext.request.contextPath}/book/bookList">책 목록</a></li>
		<li class="list-group-item"><a class="btn btn-warning btn-lg btn-block"
			href="${pageContext.request.contextPath}/company/companyList">회사 목록</a></li>
		<li class="list-group-item"><a class="btn btn-success btn-lg btn-block"
			href="${pageContext.request.contextPath}/country/countryList">나라 목록</a></li>
		<li class="list-group-item"><a class="btn btn-info btn-lg btn-block"
			href="${pageContext.request.contextPath}/idol/idolList">아이돌 목록</a></li>
		<li class="list-group-item"><a class="btn btn-primary btn-lg btn-block"
			href="${pageContext.request.contextPath}/city/cityList">도시 목록</a></li>
	</ul>
</body>
</html>