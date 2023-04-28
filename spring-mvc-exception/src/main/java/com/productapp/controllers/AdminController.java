package com.productapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String adminPage(@RequestParam("username")String username,
							@RequestParam("password")String password) {
		// check the username and password
		// if the name is admin admin123 then open admin.jsp
		if(username.equals("admin")&& password.equals("admin123"))
			return "admin";
		// else stay in the same page
		else
			return "login";
	}
	
	@RequestMapping("/addForm")
	public String showAddForm() {
		return "addForm";
	}
	
	@RequestMapping("/editForm")
	public String showEditForm() {
		return "editForm";
	}

	@RequestMapping("/deleteForm")
	public String showDeleteForm() {
		return "deleteForm";
	}
}








