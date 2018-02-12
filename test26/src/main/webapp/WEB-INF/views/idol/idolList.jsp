<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Idol List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2 col-sm-3">Idol List</h2>
			<a class="col-lg-10 col-sm-9 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<a href="${pageContext.request.contextPath}/idol/idolInsert" class="btn btn-info">ADD</a>
		<table class= "table table-striped table-hover">
		<thead>
			<tr class="info">
				<th>No.</th>
				<th>NAME</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<c:forEach var="idol" items="${list}">
			<tbody>
				<tr>
					<td>${idol.idolId}</td>
					<td>${idol.idolName}</td>
					<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/idol/idolUpdate?idolId=${idol.idolId}"><i class="fa fa-pencil"></i></a></td>
					<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/idol/idolDelete?idolId=${idol.idolId}"><i class="fa fa-trash"></i></a></td>
				</tr>
			</tbody>
		</c:forEach>
		</table> 
			<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage-1}">이전</a>
			</c:if>
			<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage+1}">다음</a>
			</c:if>

		
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
	</div>
</body>
</html>