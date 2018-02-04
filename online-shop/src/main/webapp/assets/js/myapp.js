$(function(){
	 
	 switch(menu){
	 
	   case 'about us':
	     $('#about').addClass('active');
	     break;
	   case 'contact us':
		     $('#contact').addClass('active');
		     break;
	   case 'All Products':
		     $('#listProducts').addClass('active');
		     break;
		    default:
		    	 $('#listProducts').addClass('active'); 	
		         $('#a_'+menu).addClass('active'); 	
		    
	             break;
	 }
});
