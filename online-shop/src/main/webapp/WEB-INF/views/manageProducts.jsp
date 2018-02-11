<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<div class="container">

   <div class="row">
   
    <c:if test="${not empty message}">
     
       <div class="col-xs-12">
       
          <div class="alert alert-success alert-dismissible">
          
             <button type="button" class="close" data-dismiss="alert">&times;</button>
            
              ${message }
          </div>
       
       </div>
    </c:if>   
     
      <div class="col-md-offset-2 col-md-8">
      
        <div class="panel panel-primary">
        
          <div class="panel panel-heading">
          
             <h4>Product Management!!</h4>
          
          </div>
         <div class="panel-body">
          
            <!-- form elements!!! -->
            
            <f:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" 
            method="post" enctype="multipart/form-data"    >
             
               <div class="form-group">
               
                 <label class="control-label col-md-4" for="name"> Enter product Name:</label>
                 <div class="col-md-8">
                   
                    <f:input type="text" path="name" id="name" placeholder="Product name" class="form-control" />
                     <f:errors path="name" cssClass="help-block" element="em"></f:errors>
                 </div>
               
               </div>
               <div class="form-group">
               
                 <label class="control-label col-md-4" for="brand"> Enter product Brand:</label>
                 <div class="col-md-8">
                   
                    <f:input type="text" path="brand" id="brand" placeholder="Product brand" class="form-control" />
                   <f:errors path="brand" cssClass="help-block" element="em"></f:errors>
                 
                 </div>
               
               </div>
               <div class="form-group">
               
                 <label class="control-label col-md-4" for="description"> Enter product Description:</label>
                 <div class="col-md-8">
                   
                   <f:textarea rows="4" class="form-control"  path="description" id="description" placeholder="write here a dscription"></f:textarea>
                    <f:errors path="description" cssClass="help-block" element="em"></f:errors>
                 
                 </div>
               
               </div>
               <div class="form-group">
               
                 <label class="control-label col-md-4" for="unitPrice"> Enter product unitPrice:</label>
                 <div class="col-md-8">
                   
                    <f:input type="text" path="unitPrice" id="unitPrice" placeholder="Product unitPrice" class="form-control" />
                    <f:errors path="unitPrice" cssClass="help-block" element="em"></f:errors>
                 
                 </div>
               
               </div>
               <div class="form-group">
               
                 <label class="control-label col-md-4" for="quantity"> Enter Qty Available:</label>
                 <div class="col-md-8">
                   
                    <f:input type="number" path="quantity" id="quantity" placeholder="Product quantity" class="form-control" />
                    
                 
                 </div>
               
               </div>
               
               <!-- file element ofr image upload -->
               <div class="form-group">
               
                 <label class="control-label col-md-4" for="file">Select an image:</label>
                 <div class="col-md-8">
                   
                    <f:input type="file" path="file" id="file"  class="form-control" />
                    <f:errors path="file" cssClass="help-block" element="em"></f:errors>
                 
                 </div>
               
               </div>
               
               <div class="form-group">
                 <label class="control-label col-md-4" for="categoryId">Select Category</label> 
                 <div class="col-md-8">
                   <f:select class="form-control" id="categoryId" path="categoryId"
                     items="${categories }"
                     itemLabel="name"
                     itemValue="id"
                  />
                    
                 </div>
               
               </div>
               
               <div class="form-group">
               
               
                 <div class="col-md-offset-4 col-md-8">
                   
                    <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary" />
                 
                 <!-- hidden fields for products -->
                    <f:hidden path="id"/>
                     <f:hidden path="code"/>
                      <f:hidden path="supplierId"/>
                       <f:hidden path="active"/>
                        <f:hidden path="purchases"/>
                         <f:hidden path="views"/>
                 
                 </div>
               
               </div>
            
            
            </f:form>
          
          </div>
        
        
        </div>
      
      
      </div>
   
   
   </div>

   <div class="row">
   
   
      <div class="col-xs-12">
        <h3>Available Products</h3>
        <hr/>
      </div>
       <div class="col-xs-12">
       
         <div style="overflow:auto;">
         
                   <!-- product table for admin -->
         
			<table id="adminproductsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</thBrand>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>				
				</thead>
				
			
				
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
      
        </div>
   
   
   </div>

</div>