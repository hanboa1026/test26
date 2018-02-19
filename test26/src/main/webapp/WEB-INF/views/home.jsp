<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Agency - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href="resources/css/bootstrap.min.css" rel="stylesheet"> -->
	 <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

   <!-- Custom fonts for this template -->

   <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
   <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
   <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
   <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

   <!-- Custom styles for this template -->
<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
   <link href="resources/css/agency.min.css" rel="stylesheet">
<!--      <link href="resources/css/font-awesome.min.css" rel="stylesheet"> -->

 </head>

 <body id="page-top">

   <!-- Navigation -->
   <nav class="navbar navbar-expand-lg navbar-dark fixed-top navbar-shrink" id="mainNav">
     <div class="container">
       <a class="navbar-brand js-scroll-trigger" href="#page-top">Start Bootstrap</a>
       <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
         Menu<i class="fa fa-bars"></i>
       </button>
       <div class="collapse navbar-collapse" id="navbarResponsive">
         <ul class="navbar-nav text-uppercase ml-auto">
        	 <c:if test="${empty sessionScope.loginMember}">
           <li class="nav-item">
             <a class="btn btn-warning" href="${pageContext.request.contextPath}/log/login">Login</a>
          </li>&nbsp;
           <li class="nav-item">
             <a class="btn btn-warning"  href="${pageContext.request.contextPath}/member/memberAdd">Join</a>
           </li>
           </c:if>
           <c:if test="${not empty sessionScope.loginMember}">
           <li class="nav-item">
             <a class="btn btn-warning"  href="${pageContext.request.contextPath}/log/logOut">LogOut</a>
           </li>&nbsp;
           <li class="nav-item">
             <a class="btn btn-warning"  href="${pageContext.request.contextPath}/member/memberInfo?memberNo=${loginMember.memberNo}">MyPage</a>
           </li>
           </c:if>
         </ul>
       </div>
     </div>
   </nav>

   <!-- Header -->
   <header class="masthead">
     <div class="container">
       <div class="intro-text">
         <div class="intro-lead-in">Welcome To Our Studio!</div>
         <div class="intro-heading text-uppercase">It's Nice To Meet You</div>
         <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Tell Me More</a>
       </div>
     </div>
   </header>

     <!-- Team -->
   <section class="bg-light" id="team">
     <div class="container">
       <div class="row">
         <div class="col-lg-12 text-center">
           <h2 class="section-heading text-uppercase">Our Amazing Team</h2>
           <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>
         </div>
       </div>
      <div class="row">
	<div class="col-sm-3">
	<a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
     <div class="team-member">
       <img class="mx-auto rounded-circle" src="resources/img/team/2.jpg" alt="">
       <h4>Han BoA</h4>
       <p class="text-muted">Lead Marketer</p>
     </div>
    </a>
   </div>
	<div class="col-sm-3">
	<a class="portfolio-link" data-toggle="modal" href="#portfolioModal2">
           <div class="team-member">
             <img class="mx-auto rounded-circle" src="resources/img/team/2.jpg" alt="">
             <h4>Park Mi Ran</h4>
             <p class="text-muted">Lead Marketer</p>
           </div>
          </a>
         </div>
         <div class="col-sm-3">
         <a class="portfolio-link" data-toggle="modal" href="#portfolioModal3">
           <div class="team-member">
             <img class="mx-auto rounded-circle" src="resources/img/team/2.jpg" alt="">
             <h4>Jung Eun Hwa</h4>
             <p class="text-muted">Lead Marketer</p>
           </div>
          </a>
         </div>
         <div class="col-sm-3">
          <a class="portfolio-link" data-toggle="modal" href="#portfolioModal4">
           <div class="team-member">
             <img class="mx-auto rounded-circle" src="resources/img/team/3.jpg" alt="">
             <h4>Kim Kyu Won</h4>
             <p class="text-muted">Lead Developer</p>
           </div>
           </a>
         </div>
         </div>
         </div>
       <div class="row">
         <div class="col-lg-8 mx-auto text-center">
           <p class="large text-muted">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
         </div>
       </div>
   </section>

   <!-- Portfolio Grid -->
   <section class="bg-light" id="portfolio">
     <div class="container">
       <div class="row">
         <div class="col-lg-12 text-center">
           <h2 class="section-heading text-uppercase">LIST</h2>
           <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>
         </div>
       </div>
       <div class="row">
         <div class="col-md-4 col-sm-6 portfolio-item">    
            <a class=""	href="${pageContext.request.contextPath}/book/bookList">
             <img class="img-fluid" src="resources/img/portfolio/01-thumbnail.jpg" alt="">
             </a>
           <div class="portfolio-caption">
             <h4>BOOK</h4>
             <p class="text-muted">Illustration</p>
           </div>
         </div>
         <div class="col-md-4 col-sm-6 portfolio-item">
         <a class="" href="${pageContext.request.contextPath}/city/cityList">
             <img class="img-fluid" src="resources/img/portfolio/02-thumbnail.jpg" alt="">
             </a>
           <div class="portfolio-caption">
             <h4>CITY</h4>
             <p class="text-muted">Graphic Design</p>
           </div>
         </div>
         <div class="col-md-4 col-sm-6 portfolio-item">     
         <a class=""href="${pageContext.request.contextPath}/company/companyList">  
             <img class="img-fluid" src="resources/img/portfolio/03-thumbnail.jpg" alt="">
             </a>
           <div class="portfolio-caption">
             <h4>COMPANY</h4>
             <p class="text-muted">Identity</p>
           </div>
         </div>
         <div class="col-md-2 portfolio-item">
         </div>
         <div class="col-md-4 col-sm-6 portfolio-item">
         <a class="" href="${pageContext.request.contextPath}/country/countryList">
             <img class="img-fluid" src="resources/img/portfolio/05-thumbnail.jpg" alt="">
             </a>
           <div class="portfolio-caption">
             <h4>COUNTRY</h4>
             <p class="text-muted">Website Design</p>
           </div>
         </div>
         
         <div class="col-md-4 col-sm-6 portfolio-item">
         <a class="" href="${pageContext.request.contextPath}/idol/idolList">
         <img class="img-fluid" src="resources/img/portfolio/06-thumbnail.jpg" alt="">
         </a>

           <div class="portfolio-caption">
             <h4>IDOL</h4>
             <p class="text-muted">Photography</p>
           </div>
         </div>
	<div class="col-md-2 portfolio-item">
         </div>
       </div>
     </div>
   </section>

 
   <!-- Clients -->
   <section class="py-5">
     <div class="container">
       <div class="row">
         <div class="col-md-3 col-sm-6">
           <a href="#">
             <img class="img-fluid d-block mx-auto" src="resources/img/logos/envato.jpg" alt="">
           </a>
         </div>
         <div class="col-md-3 col-sm-6">
           <a href="#">
             <img class="img-fluid d-block mx-auto" src="resources/img/logos/designmodo.jpg" alt="">
           </a>
         </div>
         <div class="col-md-3 col-sm-6">
           <a href="#">
             <img class="img-fluid d-block mx-auto" src="resources/img/logos/themeforest.jpg" alt="">
           </a>
         </div>
         <div class="col-md-3 col-sm-6">
           <a href="#">
             <img class="img-fluid d-block mx-auto" src="resources/img/logos/creative-market.jpg" alt="">
           </a>
         </div>
       </div>
     </div>
   </section>


   <!-- Footer -->
   <footer>
     <div class="container">
       <div class="row">
         <div class="col-md-4">
           <span class="copyright">Copyright &copy; Your Website 2018</span>
         </div>
         <div class="col-md-4">
         </div>
         <div class="col-md-4">
           <ul class="list-inline quicklinks">
             <li class="list-inline-item">
               <a href="#">Privacy Policy</a>
             </li>
             <li class="list-inline-item">
               <a href="#">Terms of Use</a>
             </li>
           </ul>
         </div>
       </div>
     </div>
   </footer>

   <!-- Portfolio Modals -->
   <!-- Modal 1 HanBoA-->
   <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="close-modal" data-dismiss="modal">
           <div class="lr">
             <div class="rl"></div>
           </div>
         </div>
         <div class="container">
           <div class="row">
             <div class="col-lg-8 mx-auto">
               <div class="modal-body">
                 <!-- Project Details Go Here -->
                 <h2 class="text-uppercase">Project Name</h2>
                 <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                 <img class="img-fluid d-block mx-auto" src="resources/img/portfolio/01-full.jpg" alt="">
                 <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                 <ul class="list-inline">
                   <li>Date: January 2017</li>
                   <li>Client: Threads</li>
                   <li>Category: Illustration</li>
                 </ul>
                 <button class="btn btn-primary" data-dismiss="modal" type="button">
                   <i class="fa fa-times"></i>
                   Close Project</button>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>

   <!-- Modal 2 Park Mi Ran-->
   <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="close-modal" data-dismiss="modal">
           <div class="lr">
             <div class="rl"></div>
           </div>
         </div>
         <div class="container">
           <div class="row">
             <div class="col-lg-8 mx-auto">
               <div class="modal-body">
                 <!-- Project Details Go Here -->
                 <h2 class="text-uppercase">Project Name</h2>
                 <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                 <img class="img-fluid d-block mx-auto" src="resources/img/portfolio/02-full.jpg" alt="">
                 <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                 <ul class="list-inline">
                   <li>Date: January 2017</li>
                   <li>Client: Explore</li>
                   <li>Category: Graphic Design</li>
                 </ul>
                 <button class="btn btn-primary" data-dismiss="modal" type="button">
                   <i class="fa fa-times"></i>
                   Close Project</button>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>

   <!-- Modal 3 Jung Eun Hwa-->
   <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="close-modal" data-dismiss="modal">
           <div class="lr">
             <div class="rl"></div>
           </div>
         </div>
         <div class="container">
           <div class="row">
             <div class="col-lg-8 mx-auto">
               <div class="modal-body">
                 <!-- Project Details Go Here -->
                 <h2 class="text-uppercase">Project Name</h2>
                 <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                 <img class="img-fluid d-block mx-auto" src="resources/img/portfolio/03-full.jpg" alt="">
                 <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                 <ul class="list-inline">
                   <li>Date: January 2017</li>
                   <li>Client: Finish</li>
                   <li>Category: Identity</li>
                 </ul>
                 <button class="btn btn-primary" data-dismiss="modal" type="button">
                   <i class="fa fa-times"></i>
                   Close Project</button>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>

   <!-- Modal 4 Kim kyu Won-->
   <div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="close-modal" data-dismiss="modal">
           <div class="lr">
             <div class="rl"></div>
           </div>
         </div>
         <div class="container">
           <div class="row">
             <div class="col-lg-8 mx-auto">
               <div class="modal-body">
                 <!-- Project Details Go Here -->
                 <h2 class="text-uppercase">Project Name</h2>
                 <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                 <img class="img-fluid d-block mx-auto" src="resources/img/portfolio/04-full.jpg" alt="">
                 <p>Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                 <ul class="list-inline">
                   <li>Date: January 2017</li>
                   <li>Client: Lines</li>
                   <li>Category: Branding</li>
                 </ul>
                 <button class="btn btn-primary" data-dismiss="modal" type="button">
                   <i class="fa fa-times"></i>
                   Close Project</button>
               </div>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
     
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
	
	<!-- Plugin JavaScript -->
	<script src="<c:url value="/resources/css/jquery.easing.min.js"/>"></script>
	
	<!-- Contact form JavaScript -->
	<script src="<c:url value="/resources/js/jqBootstrapValidation.js"/>"></script>
	<script src="<c:url value="/resources/js/contact_me.js"/>"></script>
	
	<!-- Custom scripts for this template -->
	<script src="<c:url value="/resources/js/agency.min.js"/>"></script>

  </body>
</html>