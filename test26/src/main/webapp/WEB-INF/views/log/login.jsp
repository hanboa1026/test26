<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css?ver=1" />" rel="stylesheet">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#loginButton').click(function(){
			if($('#memberId').val().length < 4) {
				alert('아이디는 4자 이상 입력해주세요.');
				$('#memberId').focus();
			} else if($('#memberPw').val().length < 7) {
				alert('비밀번호는 7자 이상 입력해주세요.');
				$('#memberPw').focus();
			} else {
				$('#loginForm').submit();
			}
		})
	})
</script>
<title>login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2 col-sm-3">login Form</h2>
			<a class="col-lg-10 col-sm-9 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<div class="loginWrap">
			<form class="loginForm" id="loginForm" action="${pageContext.request.contextPath}/log/loginAction" method="POST">
				<input id="memberId" class="loginInfo" name="memberId" type="text" placeholder="ID" required><br />
				<input id="memberPw" class="loginInfo" name="memberPw" type="password" placeholder="Password" required>
				<button type="button" id="loginButton" class="btn btn-lg btn-info btn-block">Login</button>
				<a href="" class="btn btn-lg btn-info btn-block">회원가입</a>
			</form>
		</div>
	</div>
</body>
</html>