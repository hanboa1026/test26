<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value="/resources/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#searchButton').click(function(){
				$('#searchCityForm').submit();
		})
	})
</script>
<title>City List</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1>City&nbsp;List</h1>
			</div>
		</div>
		<div class="row">
				<div class="col-lg-2 col-sm-3">
					<a class="homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
				</div>
				<div class="col-lg-7 col-sm-6">
					<a href="${pageContext.request.contextPath}/city/cityInsert" class="btn btn-primary">ADD</a>
				</div>
				<form action="${pageContext.request.contextPath}/city/cityList?word=${word}" method="get" id="searchCityForm" class="col-lg-3 col-sm-3 form-inline">
					<!-- 검색처리 -->
					<div class="input-group">
						<input id="searchCity" name="word" type="text" class="form-control" placeholder="Search">
						<div class="input-group-btn">
							<button id="searchButton" type="button" class="btn btn-primary">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
		</div>	
		<div class="row">
			<div class="col-lg-2">
				<jsp:include page="/WEB-INF/views/inc/left.jsp"></jsp:include>
			</div>
			<div class="col-lg-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr class="info">
							<th>No.</th>
							<th>NAME</th>
							<th>UPDATE</th>
							<th>DELETE</th>
						</tr>
					</thead>
					<c:forEach var="city" items="${list}">
						<tbody>
							<tr>
								<td>${city.cityId}</td>
								<td>${city.cityName}</td>
								<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/city/cityUpdate?cityId=${city.cityId}"><i class="fa fa-pencil"></i></a></td>
								<td><a class="btn btn-danger" href="${pageContext.request.contextPath}/city/cityDelete?cityId=${city.cityId}"><i class="fa fa-trash"></i></a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<!-- 페이징 -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:forEach var="i" begin="1" end="${countPage}" step="1">
							<li class="page-item">
								<a class="page-link" href="${pageContext.request.contextPath}/city/cityList?currentPage=${i}">${i}</a>
							</li>
						</c:forEach>
					</ul>
				</nav>
			</div>
		</div>
	</div>
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>

</body>
</html>