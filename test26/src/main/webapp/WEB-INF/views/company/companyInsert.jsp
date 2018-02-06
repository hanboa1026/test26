<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"  rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/jquery-3.3.1.min.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
   
    //    alert('jquery test');
    /* 입력폼 유효성 관련 요구사항
        1. 모든 폼은 공백 또는 "" 문자는 입력되면 안된다.
        2. 비밀번호는 4자이상 입력하여야 한다.
    */
    $(document).ready(function(){
        $('#addButton').click(function(){
           	if($('#companyName').val().length <1) {
                alert('회사 이름을 입력하세요');
                $('#companyName').focus();
            } else {
                $('#addForm').submit();
            }
        })
    })
    
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
		<h2 class="col-lg-4 col-sm-4">Company Insert Form</h2>
		<a class="col-lg-8 col-sm-8 homeicon" href="${pageContext.request.contextPath}/"><img alt="home" src="${pageContext.request.contextPath}/resources/img/home.png"></a>
		</div>
		
	 	<form action="${pageContext.request.contextPath}/companyAdd" method="post" id="addForm">
	 		<div class="alert alert-warning">
	 			<div>회사이름 이름 </div>
	 			<input type="text" id="companyName" name="companyName">
	 			<button id="addButton" class="btn btn-warning" type="button">추가</button>
	 			<button class="btn btn-warning" type="reset">초기화</button>
 			</div>
 		</form>
 		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
 	</div>

</body>
</html>
