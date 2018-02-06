<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/jquery-3.3.1.min.js"/>"></script>
<script>
		//    alert('jquery test');
	    /* 입력폼 유효성 관련 요구사항
	        1. 모든 폼은 공백 또는 "" 문자는 입력되면 안된다.
	        2. 내용은 1자이상 입력하여야 한다.
	    */
	$(document).ready(function(){
		$('#addButton').click(function(){
			if($('#countryName').val().length <1){
			alert('한글자 이상 입력해주세요.');
			$('#countryName').focus();
			}else{
				$('#addCountryForm').submit();
			}
		})
		})

</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-lg-2">Country Insert</h2>
			<a class="col-lg-10 homeicon" href="${pageContext.request.contextPath}/"><img alt="home"
				src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="addCountryForm" method="post" action="${pageContext.request.contextPath}/countryAdd">
			CountryName:<input class="form-control" id="countryName" name="countryName" type="text">
			<button id="addButton" type="button" value="글입력">ADD</button>
		</form>
	</div>

</body>

</html>