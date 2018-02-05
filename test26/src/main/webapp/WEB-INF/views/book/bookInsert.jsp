<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Insert</title>
</head>
<body>
	<div class="container">
		<h2>Book Insert Form</h2>
		<form id="bookInsertForm" action="${pageContext.request.contextPath}/book/bookInsert" method="post">
			<div>
				<div>제목을 입력해주세요.</div>
				<input type="text" name="BookName">
			</div>
				<button class="btn btn-danger" type="submit">입력</button>
				<button class="btn btn-danger" type="reset">초기화</button>
		</form>
	</div>
</body>
</html>