<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인화면<h2>
	<form action="${pageContext.request.contextPath}/log/loginAction" method="POST">
		<input name="memberId" type="text" placeholder="ID"> <br />
		<input name="memberPw" type="password" placeholder="Password">
		<button type="submit">확인</button>
	</form>
</body>
</html>