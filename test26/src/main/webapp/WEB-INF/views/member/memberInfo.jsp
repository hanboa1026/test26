<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>

<title>Member Page</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-3 col-sm-4">My Page</h2>
			<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
			<div class="alert alert-active">
				<div>회원수정</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr class="active">
							<th>NO</th>
							<th>ID</th>
							<th>LEVEL</th>
							<th>UPDATE</th>
							<th>DELETE</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td>${member.memberNo}</td>
						<td>${member.memberId}</td>
						<td>${member.memberLevel}</td>
						<td><a href="${pageContext.request.contextPath}/member/memberModify?memberNo=${member.memberNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/member/memberRemove?memberNo=${member.memberNo}">탈퇴</a></td>
					</tr>
					</tbody>
				</table>
			</div>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>