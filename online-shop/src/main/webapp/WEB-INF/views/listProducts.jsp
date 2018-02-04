<div class="container">

   <div class="row">
       
           <!-- to display actual porudcts -->
        
         <div class="col-md-9">
         
         
         <!-- added breadcrumb component -->
         
             <div class="row">
             
                <div class="col-lg-12">
                
                <c:if test="${userClickAllProducts== true}">
                  <ol class="breadcrumb">
                   
                     <li><a href="${contextRoot }/home">Home</a> </li>
                     <li class="active">All Products </li>
                      
                  </ol>
                </c:if>
                
                    
                <c:if test="${userClickCategoryProducts== true}">
                  <ol class="breadcrumb">
                   
                     <li><a href="${contextRoot }/home">Home</a> </li>
                     <li class="active">Category </li>
                      <li class="active">${category.name} </li>  <!-- from pagecontroller -->
                  </ol>
                </c:if>
                
                
                </div>
             
             </div>
         
         </div>
         
           
        <!-- woulb b diplay sidebar -->   
        <div class="col-md-3">
        
           <%@include file="./shared/sidebar.jsp" %>
        
        </div>
   
   
   </div>


</div>