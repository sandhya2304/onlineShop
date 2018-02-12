$(function(){
	 
	 switch(menu){
	 
	   case 'about us':
	     $('#about').addClass('active');
	     break;
	   case 'contact us':
		     $('#contact').addClass('active');
		     break;
	   case 'manage Products':
		     $('#manageProducts').addClass('active');
		     break;
	   case 'All Products':
		     $('#listProducts').addClass('active');
		     break;
		    default:
		    	if(menu=='Home') break;
		    	 $('#listProducts').addClass('active'); 	
		         $('#a_'+menu).addClass('active'); 	
		    
	             break;
	 }
	 //-------------------------------------------------------------------------------------------
	 //code for jquery data table to fetch all data from db in product table
	//---------------------------------------------------------------------------------------------
	 
	 var $table=$('#productListTable');
	 
	 if($table.length)
		 {
		    
		    var jsonUrl= '';
		    if(window.categoryId == '')
		    	{
		    	   jsonUrl = window.contextRoot + '/json/data/all/products';
		    	}
		    else
		    	{
		    	jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId + '/products';
		    	}
		    
		    $table.DataTable({
		    	
		    	lengthMenu: [[3,5,10,-1], ['3 records','5 records' ,'10 records ','all ']],
	    		 pageLength : 5,
		    	ajax:{
		    		
		    		url : jsonUrl,
					dataSrc : ''
		    	},
		    	columns: [
		    		       {
		    		    	 data: 'code',
		    		    	 mRender: function(data,type,row)
		    		    	 {
		    		    		 
		    		    		 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
		    		    	 }
		    		       }, 
		    		 
		    		       {
		    		    	   data: 'name'
		    		       },
		    		       {
		    		    	   data: 'brand'
		    		       },
		    		       {
		    		    	   data: 'unitPrice',
		    		    	   mRender: function(data,type,row)
		    		    	   {
		    		    		   return '&#8377;' +data
		    		    	   }
		    		       },
		    		       {
		    		    	   data: 'quantity',
		    		    	   mRender: function(data,type,row)
		    		    	   {
		    		    		   if(data < 1)
		    		    			   {
		    		    			      return "<span style='color:red'>Out of Stock</span>";
		    		    			   }
		    		    		   return data;
		    		    	   }
		    		       },
		    		       {
		    		    	   data: 'id',
		    		    	   mRender: function(data,type,row)
		    		    		   {
		    		    		   var str = '';
		      						str +='<a href="'+window.contextRoot+'/show/ '+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160; ';
		      						
		      						if(row.quantity < 1)
		      							{
		      							str +='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
		      							}
		      						else
		      							{
		      							str +='<a href="'+window.contextRoot+'/cart/add/ '+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
		      							}
		    		    			  
		    		    			   
		    		    			   return str;
		    		    		   }
		    		       }
		    		
		    	         ]
		    	
		    	
		    });
		 
		 }
	 //----------------------------------------------------------------------------------
	 // dismiss the alert after 3 seconds
	 
	 var $alert=$('.alert');
	 
	 if($alert.length)
		 {
		   
		   setTimeout(function(){
			   $alert.fadeOut('slow');			   
		   },3000)
		 
		 }
	 //-----------------------------------------------------------------------------------
	 
	
	 //-----------------------------------------------------------------
	 // data table for admin to show all data from db in admin table
	 //---------------------------------------------------------------
	 
 var $adminproductsTable=$('#adminproductsTable');
	 
	 if($adminproductsTable.length)
		 {
		    
		    var jsonUrl= window.contextRoot+'/json/data/admin/all/products';
		    
		  
		    
		    $adminproductsTable.DataTable({
		    	
		    	lengthMenu: [[10,30,50-1], ['10 records','30 records' ,'50 records ','all ']],
	    		 pageLength : 30,
		    	ajax:{
		    		
		    		url : jsonUrl,
					dataSrc : ''
		    	},
		    	columns: [
		    		{
		    			data: 'id'
		    		},
		    		       {
		    		    	 data: 'code',
		    		    	 mRender: function(data,type,row)
		    		    	 {
		    		    		 
		    		    		 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg" />';
		    		    	 }
		    		       }, 
		    		 
		    		       {
		    		    	   data: 'name'
		    		       },
		    		       {
		    		    	   data: 'brand'
		    		       },
		    		       
		    		       {
		    		    	   data: 'quantity',
		    		    	   mRender: function(data,type,row)
		    		    	   {
		    		    		   if(data < 1)
		    		    			   {
		    		    			      return "<span style='color:red'>Out of Stock</span>";
		    		    			   }
		    		    		   return data;
		    		    	   }
		    		       },
		    		       {
		    		    	   data: 'unitPrice',
		    		    	   mRender: function(data,type,row)
		    		    	   {
		    		    		   return '&#8377;' +data
		    		    	   }
		    		       },
		    		       {
		      					 data : 'active',
		      					 bSortable:false,
		      					 mRender:function(data,type,row)
		      					 {
		      						 var str = '';
		      						 
		      						if(data) {											
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
										
									}else {
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
									}
						          
		      						 return str;
		      					 }
		      						
		      				 },
		      				 {
		      					 data: 'id',
		      					bSortable:false,
		      					mRender: function(data,type,row)
		      					{
		      						var str = '';
		      						str += '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning"> ';
		   				            str +=  '<span class="glyphicon glyphicon-pencil"></span> </a>'  
		   				                     
		      						return str;
		      						
		      					}
		      					 
		      				 }
		    			       
		    				 ],
		    				 
		    				 initComplete: function()
		    				 {
		    					 //toggle button activate and deactivate the product
		    					 var api =this.api();
		    					 api.$('.switch input[type="checkbox"]').on('change',function ()
		    				    		 {
		    		    	           var checkbox= $(this);
		    		    	           var checked= checkbox.prop('checked');
		    		    	           var dmsg = (checked)? 'you want to activate your product?' : 
		    		    	        	                      'you want to deactivate?' ;
		    		    	           var value= checkbox.prop('value');
		    		    	           
		    		    	           
		    		    	           bootbox.confirm({
		    		    	        	   size: 'medium' ,
		    		    	        	   title: 'Product Activation and deactivation' ,
		    		    	        	   message: dmsg ,
		    		    	        	   callback : function (confirmed)
		    		    	        	       {
		    		    	        		      if(confirmed)
		    		    	        		    	  {
		    		    	        		    	     console.log(value);
		    		    	        		    	     //json url here from managementcontroller
		    		    	        		    	     var activationUrl=window.contextRoot + '/manage/product/' +value + '/activation' ;
		    		    	        		    	     
		    		    	        		    	     $.post(activationUrl,function(data)
		    		    	        		    	        {
		    		  	        		    	    
		    		    	        		    	    	bootbox
		        		    	        		    	     .alert({
																	size : 'medium',
																	title : 'information',
																	message : data		
																																					        		    	        		    	    																		
	        		    	        		    	    	 
		        		    	        		    	     });
		                                        	 });
			    	       		    	        		    	    
		    		    	        		    	  }
		    		    	        		      else
		    		    	        		    	  {
		    		    	        		    	  
		    		    	        		    	     checkbox.prop('checked',!checked);
		    		    	        		    	  }
		    		    	        		     
		    		    	        	       }
		    		    	        	   
		    		    	        	   
		    		    	           });
		    		    	        
		    		    		 });
		    		     
		    					 
		    				 }
		    		 
		    		 
		    	 });
		    	 }
		     
		     
	//-----------------------------------------------------------------	 
	 
	 
	 
	 
	//validation code for category

     var $categoryForm = $('#categoryForm');

   if($categoryForm.length)
     {
	   $categoryForm.validate({
		  
		   rules: {
			   
			   name: {
				   
				   required: true,
				   minlength: 2				   
			   },
			   
			   description: {
				   
				   required: true
			   }
			   
		   },
		   
		   messages: {
			   
			 name: {
				 
				 required: 'Please add the category name!' ,
				 minlength: 'catgeory name should not be less than 2 characters'
			 },
            description: {
				 
				 required: 'Please add the category description!!' ,
				
			 } 
			   
		   },
		   errorElement: 'em',
		   errorPlacement: function(error,element){
			   //add the class of help-block
			   error.addClass('help-block');
			   //add the error element after the input eleemnt
			   error.insertAfter(element);
			   
		   }
		   
	   });
	   
     }
//-----------------------------------------------------------------------------------------------
});
