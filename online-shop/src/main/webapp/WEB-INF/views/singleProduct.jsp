 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<div class="container">

<!-- breadcrumb -->
   <div class="row">
     
      <div class="col-xs-12">
      
         <ol class="breadcrumb">
         
           <li><a href="${contextRoot}/home">Home</a>     </li>
            <li><a href="${contextRoot}/show/all/products">View Products</a>     </li>
             <li class="active"> ${product.name }  </li>
         
         
         </ol>
      
      </div>
     
   
   </div>
   
   <div class="row">
     
     <!-- display the product image -->
      <div class="col-xs-12 col-sm-4">
        
         <div class="thumbnail">
         
            <img src="${images}/${product.code}.jpg" class="img img-responsive"/>
         
         </div>
         
      
      </div>
      
      <!-- product description -->
      <div class="col-xs-12 col-sm-8">
      
         <h3> Product name : ${product.name}</h3>
      
        <hr/>
        
        <p> ${product.description}</p>
        <hr/>
        
        <h4>Price: <strong> &#8377;  ${product.unitPrice } /-</strong> </h4>
        <hr/>
        
        
       
        <hr/>
        
        
           <c:choose>
				
				<c:when test="${product.quantity < 1}">
				
					<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>
					
				</c:when>
				<c:otherwise>				
					
					<h6>Qty. Available: ${product.quantity}</h6>
						
				</c:otherwise>
			
			</c:choose>
            
           <security:authorize access="hasAuthority('USER')">
           <c:choose>
				
				<c:when test="${product.quantity < 1}">
				
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
					<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</strike></a>
					
				</c:when>
				<c:otherwise>				
				
				<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
				
				
				
						
				</c:otherwise>
			
			</c:choose>
            </security:authorize>
            
            <security:authorize access="hasAuthority('ADMIN')">
            
            	<a href="${contextRoot}/manage/add/${product.id}/product" class="btn btn-warning">
				<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>
				
				
            </security:authorize>
        
        
        <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
      
      </div>
   
   
   </div>


</div>