<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/member_css.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<title>Member Join</title>
</head>
<body>
	<div class="container">
			<a class="loginHomeIcon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		<section class="joinWrap">
			<span class="joinImg"></span>
			<h2 class="joinTitle">Member Join</h2>
			<form class="joinForm" id="memberAddForm" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
					<input class="joinInfo" type="text" name="memberId" id="memberId" placeholder="아이디를 입력하세요">
					<input class="joinInfo" type="password" name="memberPw" id="memberPw" placeholder="비밀번호를 입력하세요">
					<input class="joinInfo" type="text" name="memberLevel" id="memberLevel" placeholder="입력하지망">
					<button class="joinButton" id="addButton" type="button">입력</button>
					<button class="resetButton" type="reset">초기화</button>
			</form>
		</section>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>