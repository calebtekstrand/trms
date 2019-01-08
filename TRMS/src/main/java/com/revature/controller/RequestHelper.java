package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
	
		case "/TRMS/html/Upload.do":
			System.out.println("In upload case");
			return UploadController.downloadFile(request);
		case "/TRMS/html/Login.do":
			System.out.println("In login case");
			return LoginController.Login(request);
		case "/TRMS/html/Home.do":
			System.out.println("In homecontroller case");
			return HomeController.Home(request, response);
		case "/TRMS/html/Form.do":
			System.out.println("In form case");
			return FormController.Form(request);
		default:
			return "/html/Login.html";
		}
	}

}
