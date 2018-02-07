<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
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
<title>Member Insert</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2 col-sm-3">Join</h2>
			<a class="col-lg-10 col-sm-9 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="memberAddForm" action="${pageContext.request.contextPath}/member/memberAdd" method="post">
			<div>
				<table class="table table-hover">
				<tr>
					<td class="active">ID</td>
					<td><input type="text" name="memberId" id="memberId"></td>
				</tr>
				<tr>
					<td class="active">PW</td>
					<td><input type="password" name="memberPw" id="memberPw"></td>
				</tr>
				<tr>
					<td class="active">LEVEL</td>
					<td><input type="text" name="memberLevel" id="memberLevel"></td>
				</tr>												
				</table>
				<button id="addButton" class="btn" type="button">입력</button>
				<button class="btn" type="reset">초기화</button>
			</div>
		</form>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>