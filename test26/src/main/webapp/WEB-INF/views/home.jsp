<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/book/bookList">책 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/company/companyList">회사 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/country/countryList">도시 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/idol/idolList">아이돌 목록</a></li>
		<li><a href="${pageContext.request.contextPath}/movie/movieList">영화 목록</a></li>
	</ul>
</body>
</html>
