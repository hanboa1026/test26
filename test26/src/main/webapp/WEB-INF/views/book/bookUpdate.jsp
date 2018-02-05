<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>book Update</title>
</head>
<body>
	<div class="container">
		<h2>Book Update Form</h2>
		<form id="bookUpdateForm" action="${pageContext.request.contextPath}/book/bookUpdate" method="post">
			<input type="hidden" value="${book.bookId}" name="bookId">
			<div>
				<div>제목을 수정해주세요.</div>
				<input type="text" value="${book.bookName}" name="bookName">
			</div>
				<button class="btn btn-danger" type="submit">수정</button>
				<button class="btn btn-danger" type="reset">초기화</button>
		</form>
	</div>
</body>
</html>