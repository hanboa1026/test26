<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>city Update</title>
</head>
<body>
	<div class="container">
		<h2>City Update Form</h2>
		<form id="cityUpdateForm" action="${pageContext.request.contextPath}/city/cityUpdate" method="post">
		<input type="hidden" value="${city.cityId}" name="cityId">
		<div>
			<div>도시이름을 수정해주세요.</div>
			<input type="text" value="${city.cityName}" name="cityName">
		</div>
		<button class="btn btn-primary" type="submit">수정</button>
		<button class="btn btn-primary" type="reset">초기화</button>
		</form>
	</div>
</body>
</html>