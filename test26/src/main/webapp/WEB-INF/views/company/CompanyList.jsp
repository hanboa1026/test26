<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>Company List</h2>
	<table class="table tableborded">
		<tr>
			<th>No.</th>
			<th>Sub</th>
		</tr>
		<c:forEach var="company" items="${list}">
		<tr>
			<td>${company.companyId}</td>
			<td>${company.companyName}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>