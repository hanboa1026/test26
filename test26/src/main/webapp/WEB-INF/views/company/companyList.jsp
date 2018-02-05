<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<table class="table tableborded" >
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
	<a href="${pageContext.request.contextPath}/company/companyInsertForm"><button type="submit">회사 추가</button></a>
	<a href="${pageContext.request.contextPath}/"><button type="submit">홈으로</button></a>
	</body>
</html>