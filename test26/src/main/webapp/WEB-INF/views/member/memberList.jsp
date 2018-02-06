<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<title>member List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2 col-sm-3">member List</h2>
			<a class="col-lg-10 col-sm-9 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<a href="${pageContext.request.contextPath}/book/bookInsert" class="btn">ADD</a>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="active">
					<th>No.</th>
					<th>ID</th>
					<th>LEVEL</th>
					<th>UPDATE</th>
					<th>DELETE</th>
				</tr>
			</thead>
			<c:forEach var="member" items="${list}">
			<tbody>
				<tr>
					<td>${member.memberNo}</td>
					<td>${member.memberId}</td>
					<td>${member.memberLevel}</td>
					<td><a href="${pageContext.request.contextPath}/member/memberModify?memberNo=${member.memberNo}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/member/memberRemove?memberNo=${member.memberNo}">삭제</a></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>