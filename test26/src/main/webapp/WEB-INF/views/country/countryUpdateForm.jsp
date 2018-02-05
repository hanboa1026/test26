<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Country Update Form</h2>
		<form id="modifyCountry" method="post"
			action="${pageContext.request.contextPath}/countryModify">
			<table>
				<thead>
					<tr class="danger">
						<th>No.</th>
						<th>NAME</th>
					</tr>
				</thead>
					<tbody>
						<tr>
							<td><input name="countryId" type="hidden" value="${country.countryId}" ></td>
							<td><input name="countryName" type="text" value="${country.countryName}"></td>
						</tr>
					</tbody>

			</table>
			<button type="submit">MODIFY</button>
		</form>
	</div>
</body>
</html>