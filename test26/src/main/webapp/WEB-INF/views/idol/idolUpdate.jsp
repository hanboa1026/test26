<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Idol 수정화면</title>
</head>
<script type="text/javascript" src="/context/resources/js/jquery-3.3.1.min.js"/></script>
<body>
	<div class="container">
		<h2>Idol Update Form</h2>
		<form id="idolUpdateForm" action="${pageContext.request.contextPath}/idol/idolUpdate" method="post">
			<input type="hidden" value="${idol.idolId}" name="idolId">
			<div>
				<div>Idol 이름을 수정 해주세요.</div>
				<input type="text" value="${idol.idolName}" name="idolName">
			</div>
					<button class="btn btn-danger" type="submit">수정</button>
					<button class="btn btn-danger" type="reset">초기화</button>
		</form>
		
	</div>

</body>
</html>