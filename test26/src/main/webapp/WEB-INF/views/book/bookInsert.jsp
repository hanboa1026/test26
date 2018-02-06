<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addButton').click(function(){
			if($('#bookName').val().length < 1) {
				alert('한글자 이상 입력해주세요.');
				$('bookName').focus();
			} else {
				$('#bookInsertForm').submit();
			}
		})
	})
</script>
<title>Book Insert</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<h2 class="col-lg-3 col-sm-4">Book ADD Form</h2>
		<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="bookInsertForm" action="${pageContext.request.contextPath}/book/bookInsert" method="post">
			<div class="alert alert-danger">
				<div>제목을 입력해주세요.</div>
				<input type="text" name="bookName" id="bookName">
				<button id="addButton" class="btn btn-danger" type="button">입력</button>
				<button class="btn btn-danger" type="reset">초기화</button>
			</div>
		</form>
	</div>
</body>
</html>