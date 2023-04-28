package com.productapp.exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
//responsible for handling all the exceptions that occur in all the controllers
public class MyGlobalExceptionHandler {

	// handler method
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDataAccess(DataAccessException e) {
		System.out.println("data access exception...");
		// process the exception
		ModelAndView modelView = new ModelAndView("home", "errorMessage", e.getMessage());
		return modelView;
	}

	// handler method
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		System.out.println("exception...");
		// process the exception
		ModelAndView modelView = new ModelAndView("home", "errorMessage", "exception occured");
		return modelView;
	}

}
