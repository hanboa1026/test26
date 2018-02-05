<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Company Update</title>
</head>
<body>
	<div class="container">
		<h2>Company Update Form</h2>
		<form id="companyUpdateForm" action="${pageContext.request.contextPath}/company/companyUpdate" method="post">
			<input type="hidden" value="${company.companyId}" name="companyId">
			<div>
				<div>이름을 수정해주세요.</div>
				<input type="text" value="${company.companyName}" name="companyName">
			</div>
				<button class="btn btn-danger" type="submit">수정</button>
				<button class="btn btn-danger" type="reset">초기화</button>
		</form>
	</div>
</body>
</html>