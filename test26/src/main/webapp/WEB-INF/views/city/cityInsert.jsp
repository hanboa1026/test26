<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"rel="stylesheet">
<script type="text/javascript"src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script>
	$(document).ready(function() {
		$('#addButton').click(function() {
			if($('#cityName').val() == '') {
				alert('도시이름을 입력해주세요.');
				$('cityName').focus();
			} else {
				$('#cityInsertForm').submit();
			}
		})
	})
</script>
<title>city Insert</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-3 col-sm-4">City ADD Form</h2>
			<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="cityInsertForm" action="${pageContext.request.contextPath}/city/cityInsert" method="post" enctype="multipart/form-data">
			<div class="alert alert-info">
				<div>도시를 등록해주세요.</div>
				<input type="text" name="cityName" id="cityName" placeholder="도시 이름">
				<input type="file" name="file" multiple="multiple">
				<button id="addButton" class="btn btn-primary" type="button">입력</button>
				<button class="btn btn-primary" type="reset">초기화</button>
			</div>
		</form>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>