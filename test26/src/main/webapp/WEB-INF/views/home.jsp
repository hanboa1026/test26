<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Landing Page - Start Bootstrap Theme</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/min_css/min_css.css" />" rel="stylesheet">
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link href="<c:url value= "/resources/simple-line-icons/css/simple-line-icons.css"/>"rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link  href="<c:url value= "/resources/css/landing-page.min.css"/>" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
   	<jsp:include page="/WEB-INF/views/inc/top.jsp"></jsp:include>
    </nav>
    
	<!-- Masthead -->
	<header class="masthead text-white text-center">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-5">Build</h1>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<form>
						<div class="form-row">
							<div class="col-12 col-md-9 mb-2 mb-md-0">
								<input type="email" class="form-control form-control-lg"
									placeholder="Enter your email...">
							</div>
							<div class="col-12 col-md-3">
								<button type="submit" class="btn btn-block btn-lg btn-primary">Sign
									up!</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</header>

	<!-- Icons Grid -->
	<section class="features-icons bg-light text-center">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div >
							<a class="features-icons-icon d-flex"
							href="${pageContext.request.contextPath}/book/bookList"><i class="icon-book-open m-auto text-danger"></i></a>
						</div>						
						<h3>BOOK LIST</h3>
						<p class="lead mb-0">This theme will look great on any device,
							no matter the size!</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div >
							<a class="features-icons-icon d-flex"
							href="${pageContext.request.contextPath}/city/cityList"><i class="icon-star m-auto text-warning"></i></a>
						</div>
						<h3>CITY LIST</h3>
						<p class="lead mb-0">Featuring the latest build of the new
							Bootstrap 4 framework!</p>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
						<div >
							<a class="features-icons-icon d-flex"
							href="${pageContext.request.contextPath}/company/companyList"><i class="icon-briefcase m-auto text-info"></i></a>
						</div>
						<h3>COMPANY LIST</h3>
						<p class="lead mb-0">Ready to use with your own content, or
							customize the source files!</p>
					</div>
				</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
				<div class="col-lg-6">
					<div class="features-icons-item mx-auto mb-0 mb-lg-3">
						<div >
							<a class="features-icons-icon d-flex"
							href="${pageContext.request.contextPath}/country/countryList"><i class="icon-home m-auto text-primary"></i></a>
						</div>
						<h3>COUNTRY LIST</h3>
						<p class="lead mb-0">Ready to use with your own content, or
							customize the source files!</p>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="features-icons-item mx-auto mb-0 mb-lg-3">
						<div >
							<a class="features-icons-icon d-flex"
							href="${pageContext.request.contextPath}/idol/idolList"><i class="icon-heart m-auto text-primary"></i></a>
						</div>
						<h3>IDOL LIST</h3>
						<p class="lead mb-0">Ready to use with your own content, or
							customize the source files!</p>
					</div>
				</div>
			</div>
			</div>
	</section>

	<!-- Image Showcases -->
	<section class="showcase">
		<div class="container-fluid p-0">
			<div class="row no-gutters">

			<div class="col-lg-6 order-lg-2 text-white showcase-img"
					style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-showcase-1.jpg');"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>Fully Responsive Design</h2>
					<p class="lead mb-0">When you use a theme created by Start
						Bootstrap, you know that the theme will look great on any device,
						whether it's a phone, tablet, or desktop the page will behave
						responsively!</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 order-lg-2 text-white showcase-img"
					style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-showcase-2.jpg');"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>Updated For Bootstrap 4</h2>
					<p class="lead mb-0">Newly improved, and full of great utility
						classes, Bootstrap 4 is leading the way in mobile responsive web
						development! All of the themes on Start Bootstrap are now using
						Bootstrap 4!</p>
				</div>
			</div>
			<div class="row no-gutters">
				<div class="col-lg-6 order-lg-2 text-white showcase-img"
					style="background-image: url('${pageContext.request.contextPath}/resources/img/bg-showcase-3.jpg');"></div>
				<div class="col-lg-6 order-lg-1 my-auto showcase-text">
					<h2>Easy to Use &amp; Customize</h2>
					<p class="lead mb-0">Landing Page is just HTML and CSS with a
						splash of SCSS for users who demand some deeper customization
						options. Out of the box, just add your content and images, and
						your new landing page will be ready to go!</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Testimonials -->
	<section class="testimonials text-center bg-light">
		<div class="container">
			<h2 class="mb-5">Makers</h2>
			<div class="row">
				<div class="col-lg-3">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<img class="img-fluid rounded-circle mb-3"
							src="resources/img/testimonials-1.jpg" alt="">
						<h5>Han BoA</h5>
						<p class="font-weight-light mb-0">"This is fantastic! Thanks
							so much guys!"</p>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<img class="img-fluid rounded-circle mb-3"
							src="resources/img/testimonials-2.jpg" alt="">
						<h5>Kim Kyu Won</h5>
						<p class="font-weight-light mb-0">"Bootstrap is amazing. I've
							been using it to create lots of super nice landing pages."</p>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<img class="img-fluid rounded-circle mb-3"
							src="resources/img/testimonials-3.jpg" alt="">
						<h5>Park Mee Ran</h5>
						<p class="font-weight-light mb-0">"Thanks so much for making
							these free resources available to us!"</p>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="testimonial-item mx-auto mb-5 mb-lg-0">
						<img class="img-fluid rounded-circle mb-3"
							src="resources/img/testimonials-3.jpg" alt="">
						<h5>Jung Eun Hya</h5>
						<p class="font-weight-light mb-0">"Thanks so much for making
							these free resources available to us!"</p>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Bootstrap core JavaScript -->
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
</body>

</html>
