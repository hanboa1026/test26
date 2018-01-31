<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Idol List</title>
</head>
<body>
	<h2>Idol List</h2>
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
		<c:forEach var="idol" items="${list}">
		<tr>
			<td>${idol.idolId}</td>
			<td>${idol.idolName}</td>
		</tr>
		
		</c:forEach>
			
	</table>


</body>
</html>