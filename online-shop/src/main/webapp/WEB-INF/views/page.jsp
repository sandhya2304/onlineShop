<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
    
   <spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

    <c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
    

    <title> Online Shopping - ${title }</title>
    
    <script>
    
       window.menu = '${title }';
       window.contextRoot = '${contextRoot}';
     
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
      <!-- bootsrap readable theme -->
 <!--  <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> -->  
    
    
<!-- Bootstrap datatable plugin -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

	<div class="wrapper">
		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		
		<div class="content">
		
		
			<!-- loading the hoke conetent home.jsp -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- loading only when user clicks about -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- loading only when user clicks contact -->
			<c:if test="${userClickcontact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- loading only when all pategoryroducts or c  -->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			
			<!-- loading only when user click show products  -->
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
	
    	<!-- loading only when all mange products  -->
			<c:if test="${userClickManageProducts == true}">
				<%@include file="manageProducts.jsp"%>
			</c:if>
	
	
    	<!-- loading only when all mange products  -->
			<c:if test="${userClickCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
	
	

		</div>
		<!-- /.container -->

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js }/jquery.js"></script>
		
		<!-- for validation client side -->
		<script src="${js }/jquery.validate.js"></script>
		
		<script src="${js }/bootstrap.min.js"></script>
		
		<script src="${js }/jquery.dataTables.js"></script>

             <!-- datatable botstrap -->
        	<script src="${js }/dataTables.bootstrap.js"></script>
        
         <!-- bootbox -->
		<script src="${js}/bootbox.min.js"></script>
      
		<!-- self coded javascript link here-->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>

