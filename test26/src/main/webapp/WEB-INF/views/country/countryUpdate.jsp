<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/jquery-3.3.1.min.js"/>"></script>
<script>
		//    alert('jquery test');
	    /* 입력폼 유효성 관련 요구사항
	        1. 모든 폼은 공백 또는 "" 문자는 입력되면 안된다.
	        2. 내용은 1자이상 입력하여야 한다.
	    */
	$(document).ready(function(){
		$('#modiButton').click(function(){
			if($('#countryName').val().length <1){
			alert('한글자 이상 입력해주세요.');
			$('#countryName').focus();
			}else{
				$('#modifyCountryForm').submit();
			}
		})
		})
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2">Country Update</h2>
			<a class="col-lg-10 homeicon"
				href="${pageContext.request.contextPath}/"><img alt="home"
				src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="modifyCountryForm" method="post"
			action="${pageContext.request.contextPath}/countryModify">
			<table class="table table-striped table-hover">
				<thead >
					<tr class="success">
						<th>No.</th>
						<th>NAME</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="countryId" type="hidden"
							value="${country.countryId}"></td>
						<td><input id="countryName" name="countryName" type="text"
							value="${country.countryName}"></td>
					</tr>
				</tbody>

			</table>
			<button id="modiButton" type="button"  class="btn btn-success">MODIFY</button>
		</form>
	</div>
</body>
</html>