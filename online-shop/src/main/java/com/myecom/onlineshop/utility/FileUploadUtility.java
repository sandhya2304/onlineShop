package com.myecom.onlineshop.utility;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility 
{
	
	private static final String ABS_PATH="C:\\Users\\dlc\\git\\onlineShop\\online-shop\\src\\main\\webapp\\assets\\images";
	
	private static String REAL_PATH="";

	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class); 
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code)
	{
		//calculate real path
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info("pleaese give info of real path");
		
		//to make sure all direstoty exist if not then create
		
		if(!new File(ABS_PATH).exists())
		{
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists())
		{
			new File(REAL_PATH).mkdirs();
		}
		
		try
		{
			//server uppload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			
			//project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	

}
