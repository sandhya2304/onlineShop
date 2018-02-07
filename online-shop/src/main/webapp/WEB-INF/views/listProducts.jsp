<div class="container">

   <div class="row">
       
           <!-- to display actual proudcts -->
        
         <div class="col-md-9">
         
         
         <!-- added breadcrumb component -->
         
             <div class="row">
             
                <div class="col-lg-12">
                
                <c:if test="${userClickAllProducts == true}">
                <!-- if user clicks all product then empty -->
                
                
                        <script>
							window.categoryId = '';
						</script>
                    
                  <ol class="breadcrumb">
                  
                     <li><a href="${contextRoot }/home">Home</a> </li>
                     <li class="active">All Products </li>
                      
                  </ol>
                </c:if>
                
                    
                <c:if test="${userClickCategoryProducts == true}">
                
                <!-- show products based on category,  if catgeory producst then with id -->
                
                <!-- if user clicks all product then empty -->
                    
                   
                        <script>
							window.categoryId = '${category.id}';
						</script>
                   
                  <ol class="breadcrumb">
                   
                     <li><a href="${contextRoot }/home">Home</a> </li>
                     <li class="active">Category </li>
                      <li class="active">${category.name} </li>  <!-- from pagecontroller -->
                  </ol>
                  
                </c:if>
                
                
                </div>
             
             </div>
         
         
           <div class="row">
             
             <div class="col-xs-12">
             
               <table id="productListTable" class="table table-striped table-bordered">
                
                  <thead>
                  
                    <tr>
                       <th></th>
                       <th>Name:</th>
                        <th>Brand:</th>
                        <th>Price: </th>
                        <th>Quantity: </th>
                        <th></th>
                        
                    </tr>
                  </thead>
                  
                  <tfoot>
                  
                    <tr>
                       <th></th>
                       <th>Name:</th>
                        <th>Brand:</th>
                        <th>Price: </th>
                        <th>Quantity: </th>
                        <th></th>
                        
                    </tr>
                  
                  </tfoot>
               
               </table>
             
             </div>
           
           </div>      
         
         </div>
         
           
        <!-- woulb b diplay sidebar -->   
        <div class="col-md-3">
        
           <%@include file="./shared/sidebar.jsp" %>
        
        </div>
   
   
   </div>


</div>