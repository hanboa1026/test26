<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Idol List</title>
</head>
<body>
	<div class="container">
	<h2>Idol List</h2>
	<table class= "table tableborded">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
		<c:forEach var="idol" items="${list}">
	<tbody>
		<tr>
			<td>${idol.idolId}</td>
			<td>${idol.idolName}</td>
			<td><a href="">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/idol/idolDelete?idolId=${idol.idolId}">삭제</a></td>
		</tr>
	</tbody>	
		</c:forEach>
			
	</table>
		<a href="${pageContext.request.contextPath}/idol/idolInsert">Idol 등록</a>

	</div>
</body>
</html>