package com.greetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@RequestMapping("/sayHello")
	public String helloUser(Model model) {
		// can the service layer and the result
		// create a model and give a reference name
		model.addAttribute("message", "Have a good day");
		// pass the return value as the name of the view page
		return "success";
	}
	
	@RequestMapping("/welcome")
	public String welcome(ModelMap map) {
		// create a model object
		map.addAttribute("message","Welcome to MVC");
		return "success";
		
	}
	@RequestMapping("/greetUser")
	public ModelAndView greet() {
		//create a ModelAndView object
		ModelAndView modelView = new ModelAndView("success", "message", "Greetings for the day!!");
		return modelView;
	}
	
	
}
