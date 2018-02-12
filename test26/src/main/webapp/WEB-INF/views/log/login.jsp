<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/member_css.css?ver=1" />" rel="stylesheet">
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
		<a class="loginHomeIcon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		<section class="loginWrap">
			<span class="loginImg"></span>
			<h2 class="loginTitle">Member Login</h2>
			<form class="loginForm" id="loginForm" action="${pageContext.request.contextPath}/log/loginAction" method="POST">
				<input class="loginInfo" id="memberId" name="memberId" value="kyuwonism" placeholder='User Name' type='text'>
				<input class="loginInfo" id="memberPw" name="memberPw" value="1234567" placeholder='Password' type='password'>
	  			<button id="loginButton">LOGIN</button>
	  		</form>
			<h3 class="aWrap">
	    		<a class="joinMessge" href='${pageContext.request.contextPath}/member/memberAdd'>회원가입하실래요?</a>
	 		</h3>
		</section>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>