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
		<div class="row">
		<h2 class="col-lg-3 col-sm-4">Idol 입력화면</h2>
		
		<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="addIdolForm" method="post" action="${pageContext.request.contextPath }/idolAdd" enctype="multipart/form-data">
			<div class="alert alert-info">
				<div>IdolName</div>
				<input class="form-control" type="text" name="IdolName" id="idolName">
				<div>파일</div>
				<input type="file" name="file" multiple="multiple">
				<button id="addButton" class="btn btn-info" type="submit">등록</button>
				<button class="btn btn-info" type="reset">초기화</button>
			</div>
		</form>		
			<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>