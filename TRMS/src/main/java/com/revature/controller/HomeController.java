package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DownloadDAOImpl;
import com.revature.model.Attachment;
import com.revature.model.User;

public class HomeController {

	public static String Home(HttpServletRequest request, HttpServletResponse response) {
		User user = (User)request.getSession().getAttribute("User");
		DownloadDAOImpl dw = new DownloadDAOImpl();
		Attachment attachment = dw.getBlob();
		user.setBase64(attachment.getaBase64());
		System.out.println(user.toString());
		System.out.println(user.getBase64());
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
