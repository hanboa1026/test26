<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<script type="text/javascript" src="/context/resources/js/jquery-3.3.1.min.js"/></script>

<script>
    $(document).ready(function(){
    //    alert('jquery test');
    /* 입력폼 유효성 관련 요구사항
        1. 모든 폼은 공백 또는 "" 문자는 입력되면 안된다.
        2. 비밀번호는 4자이상 입력하여야 한다.
    */
        $('#addButton').click(function(){
           	if($('#companyName').val()=='') {
                alert('회사 이름을 입력하세요');
                $('#companyName').focus();
            } else {
                $('#addForm').submit();
            }
        });
    });
    
</script>
<title>Company Update</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<h2 class="col-lg-3 col-sm-4">Company Update Form</h2>
		<a class="col-lg-9 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		<form id="companyUpdateForm" action="${pageContext.request.contextPath}/company/companyUpdate" method="post">
				<input type="hidden" value="${company.companyId}" name="companyId">
				<div class="alert alert-warning">
					<div>이름을 수정해주세요.</div>			
					<input type="text" value="${company.companyName}" id="companyName" name="companyName">
				<button class="btn btn-warning" type="submit" id="addButton">수정</button>
				<button class="btn btn-warning" type="reset">초기화</button>
				</div>
		</form>
	</div>
</body>
</html>