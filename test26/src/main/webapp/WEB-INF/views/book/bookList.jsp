<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<style type="text/css">
	.homeicon {
		padding-top: 12px;
	}
</style>
<title>book List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2">book List</h2>
			<a class="col-lg-10 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<a href="${pageContext.request.contextPath}/book/bookInsert" class="btn btn-danger">추가하기</a><br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>넘버</th>
					<th>제목</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<c:forEach var="book" items="${list}">
			<tbody>
				<tr>
					<td>${book.bookId}</td>
					<td>${book.bookName}</td>
					<td><a href="${pageContext.request.contextPath}/book/bookUpdate?bookId=${book.bookId}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/book/bookDelete?bookId=${book.bookId}">삭제</a></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>