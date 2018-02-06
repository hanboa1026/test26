<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addButton').click(function(){
			if($('#idolName').val().length < 1) {
				alert('한글자 이상 입력해주세요.');
			} else {
				$('#insertIdol').submit();
			}
		})
	})
</script>
<title>Idol 입력화면</title>
</head>

<body>
	<div class="container">
		<h2>Idol 입력화면</h2>
		<form id="insertIdol" method="post" action="${pageContext.request.contextPath }/idol/idolInsert">
			<div>
				<div>IdolName</div>
				<input type="text" name="IdolName" id="idolName">
			</div>
		<button id="addButton" class="btn btn-danger" type="button">등록</button>
		<button class="btn btn-danger" type="reset">초기화</button>
		</form>
	</div>
</body>
</html>