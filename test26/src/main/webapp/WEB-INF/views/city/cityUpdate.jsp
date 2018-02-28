<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#updateButton').click(function(){
			if($('#cityName').val().length < 1) {
				alert('한글자 이상 입력해주세요.');
				$('cityName').focus();
			} else {
				$('#cityUpdateForm').submit();
			}
		})
	})
</script>
<title>city Update</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-3 col-sm-4">City Update Form</h2>
			<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="cityUpdateForm" action="${pageContext.request.contextPath}/city/cityUpdate" method="post">
		<input type="hidden" value="${cityAndCityFile.cityId}" name="cityId">
		<div class="alert alert-info">
			<div>도시이름을 수정해주세요.</div>
			<input type="text" value="${cityAndCityFile.cityName}" name="cityName">
			<c:forEach var="cityFile" items="${cityAndCityFile.list}">
				${cityFile.fileName}
				<img src="${pageContext.request.contextPath}/resources/upload/city/${cityFile.fileName}.${cityFile.fileExt}" >
			</c:forEach>
		</div>
		<button id="updateButton" class="btn btn-primary" type="submit">수정</button>
		<button class="btn btn-primary" type="reset">초기화</button>
		</form>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>