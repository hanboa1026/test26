<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<title>Idol List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2 col-sm-3">Idol List</h2>
			<a class="col-lg-10 col-sm-9 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<a href="${pageContext.request.contextPath}/idol/idolInsert" class="btn btn-info">idol ADD</a>
		<table class= "table table-striped table-hover">
		<thead>
			<tr class="info">
				<th>No.</th>
				<th>NAME</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<c:forEach var="idol" items="${list}">
			<tbody>
				<tr>
					<td>${idol.idolId}</td>
					<td>${idol.idolName}</td>
					<td><a href="${pageContext.request.contextPath}/idol/idolUpdate?idolId=${idol.idolId}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/idol/idolDelete?idolId=${idol.idolId}">삭제</a></td>
				</tr>
			</tbody>	
		</c:forEach>
		</table>
	</div>
</body>
</html>