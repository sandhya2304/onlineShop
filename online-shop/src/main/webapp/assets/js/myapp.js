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
	 
	 //code for jquery data table 
	
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
	 
	 // dismiss the alert after 3 seconds
	 
	 var $alert=$('.alert');
	 
	 if($alert.length)
		 {
		   
		   setTimeout(function(){
			   $alert.fadeOut('slow');			   
		   },3000)
		 
		 }
	 
	 
		 
});
