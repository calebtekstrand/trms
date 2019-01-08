package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.revature.dao.UploadImpl;


public class UploadController {
	
	public static String downloadFile(HttpServletRequest request) {
			
	        try {
	            // Apache Commons-Fileupload library classe
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload sfu  = new ServletFileUpload(factory);
	
	            if (! ServletFileUpload.isMultipartContent(request)) {
	                System.out.println("sorry. No file uploaded");
	                return "/html/Home.html";
	            }
	            // parse request
	            List items = sfu.parseRequest(request);
	            FileItem  file = (FileItem) items.get(0);

	            
	            //upload file
	            UploadImpl upload = new UploadImpl();
	            upload.uploadImage(file);
	        }catch(Exception e) {
	           e.printStackTrace();
	        }
	        
	        return "/html/Home.html";
		}


}
