<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>book List</title>
</head>
<body>
	<h2>book List</h2>
	<table border=1>
		<tr>
			<th>넘버</th>
			<th>제목</th>
		</tr>
		<c:forEach var="book" items="${list}">
		<tr>
			<td>${book.bookId}</td>
			<td>${book.bookName}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>