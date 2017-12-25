<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%-- <spring:url var="js" value="/resources/js" /> --%>
<%-- <spring:url var="images" value="/resources/images" /> --%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
</script>


<!-- Bootstrap core CSS -->
<!--    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- char here -->

<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap-readable-theme.css -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<!--     change here by amir <link href="css/shop-homepage.css" rel="stylesheet"> -->
<link href="${css}/myapp.css" rel="stylesheet">


</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!--   		Loading the Page Content(home page) -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
<%-- 				<%@include file="./shared/footer.jsp"%> --%>
			</c:if>

			<!--   		Loading the Page about -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!--   		Loading the Page Contact -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!--   		Loading the Page Contact -->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			
		</div>



		<!-- /.container -->

		<!-- Footer -->
			<%@include file="./shared/footer.jsp" %>
 
		<!-- Bootstrap core JavaScript -->
		<!--     <script src="vendor/jquery/jquery.min.js"></script> -->
		<!--    change by amir <script src="js/jquery.min.js"></script> -->
		<script src="${js}/jquery.min.js"></script>

		<!--    change here by amir <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!--     SELF CODE JAVA SCRIPT -->
		<script src="${js}/myapp.js"></script>

		<!-- Add line here for VENDOR FOLDER CODE-->
	</div>
</body>
</html>

<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <body> -->
<%-- 	context root is : ${contextRoot} <br> --%>
<%-- 	greeting is : ${greeting} --%>
<!-- </body> -->
<!-- </html> -->