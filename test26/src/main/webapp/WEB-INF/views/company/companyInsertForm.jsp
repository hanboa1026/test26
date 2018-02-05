<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회사 입력 화면</h2>
 	<form action="${pageContext.request.contextPath}/companyAdd" method="post">
 		<div>
 			회사이름 이름 : <input type="text" name="companyName">
 			<button type="submit">추가</button>
 		</div>
 	
 	</form>
</body>
</html>