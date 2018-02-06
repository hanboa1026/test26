<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Idol 입력화면</title>
</head>
<script type="text/javascript" src="/context/resources/js/jquery-3.3.1.min.js"/></script>
<body>
	<div class="container">
		<h2>Idol 입력화면</h2>
		<form id="insertIdol" method="post" action="${pageContext.request.contextPath }/idol/idolInsert">
			IdolName:<input name="IdolName" type="text">
		<button class="btn btn-danger" type="submit">등록</button>
		<button calss="btn btn-danger" type="reset">초기화</button>
		</form>
	</div>
</body>
</html>