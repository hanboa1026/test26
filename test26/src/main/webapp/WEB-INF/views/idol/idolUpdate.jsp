<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#updateButton').click(function(){
			if($('#idolName').val().length < 1) {
				alert('한글자 이상 입력해주세요.');
				$('idolName').focus();
			} else {
				$('#idolUpdateForm').submit();
			}
		})
	})
</script>
<title>Idol 수정화면</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<h2 class="col-lg-3 col-sm-4">Idol Update Form</h2>
		<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="idolUpdateForm" action="${pageContext.request.contextPath}/idol/idolUpdate" method="post">
			<input type="hidden" value="${idol.idolId}" name="idolId">
			<div class="alert alert-info">
				<div>Idol 이름을 수정 해주세요.</div>
				<input type="text" value="${idol.idolName}" name="idolName" id="idolName">
				<button id="updateButton" class="btn btn-info" type="button">수정</button>
				<button class="btn btn-info" type="reset">초기화</button>
			</div>
		</form>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>

</body>
</html>