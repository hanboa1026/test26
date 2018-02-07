<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>

<title>Member Page</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-3 col-sm-4">My Page</h2>
			<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
			<div>
				<table class="table table-hover">
				<tr>
					<td class="active">ID</td>
					<td>${member.memberId}</td>
				</tr>
				<tr>
					<td class="active">PW</td>
					<td>${member.memberPw}</td>
				</tr>
				<tr>
					<td class="active">LEVEL</td>
					<td>${member.memberLevel}</td>
				</tr>											
				</table>
					<a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/member/memberModify?memberNo=${member.memberNo}"><i class="fa fa-pencil"></i></a>
					<a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/member/memberRemove?memberNo=${member.memberNo}"><i class="fa fa-trash"></i></a>
			</div>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>