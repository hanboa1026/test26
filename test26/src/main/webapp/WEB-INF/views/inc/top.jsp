<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
		<div class="container-fluid p-0">
			<div class="row no-gutters">
				<div class="col-lg-7">
				<h1>HOME, OHAYOU</h1>
				</div>
				<div class="col-lg-5">
				<c:if test="${empty sessionScope.loginMember}">
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/log/login">Login</a>
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/member/memberAdd">Join</a>
				</c:if>
				<c:if test="${not empty sessionScope.loginMember}">
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/log/logOut">LogOut</a>
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/member/memberInfo?memberNo=${loginMember.memberNo}">MyPage</a>
				</c:if>
			</div>
		</div>
  </div>
</nav>