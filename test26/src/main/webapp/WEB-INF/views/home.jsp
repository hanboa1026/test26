<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
	<title>HOME</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>HOME</h1>
			</div>
		</div>
		<div class="row">
				<div class="col-lg-8">
				<br>
				</div>
				<div class="col-lg-4">
				<c:if test="${empty sessionScope.loginMember}">
					<a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/log/login">Login</a>
					<a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/member/memberAdd">Join</a>
				</c:if>
				<c:if test="${not empty sessionScope.loginMember}">
					<a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/log/logOut">LogOut</a>
					<a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/member/memberInfo?memberNo=${loginMember.memberNo}">MyPage</a>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-2">
				<jsp:include page="/WEB-INF/views/inc/left.jsp"></jsp:include>
			</div>
			<div class="col-lg-10">
				<img alt="pig" class="homeimg" src="${pageContext.request.contextPath}/resources/img/pig.png">
				<img alt="monkey" class="homeimg" src="${pageContext.request.contextPath}/resources/img/monkey.png">
				<img alt="sheep" class="homeimg" src="${pageContext.request.contextPath}/resources/img/sheep.png">
				<img alt="snake" class="homeimg" src="${pageContext.request.contextPath}/resources/img/snake.png">
			</div>
		</div>
			<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>
