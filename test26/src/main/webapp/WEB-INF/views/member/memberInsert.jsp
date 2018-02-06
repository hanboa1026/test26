<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#addButton').click(function(){
			if($('#memberId').val().length < 4) {
				alert('아이디는 4글자 이상 입력해주세요.');
				$('#memberId').focus();
			}else if($('#memberPw').val().length < 7){
				alert('비밀번호는 7글자 이상 입력해주세요.')
				$('#memberPw').focus();
			}else {
				$('#memberAddForm').submit();
			}
		})
	})
</script>
<title>Member Insert</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-3 col-sm-4">Member ADD Form</h2>
			<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="memberAddForm" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
			<div class="alert alert-active">
				<div>회원가입</div>
				ID : <input type="text" name="memberId" id="memberId">
				PW : <input type="password" name="memberPw" id="memberPw">
				LEVEL : <input type="text" name="memberLevel" id="memberLevel">
				<button id="addButton" class="btn" type="button">입력</button>
				<button class="btn" type="reset">초기화</button>
			</div>
		</form>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>