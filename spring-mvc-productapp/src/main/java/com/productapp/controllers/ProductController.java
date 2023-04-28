package com.productapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.productapp.model.Product;

@Controller
public class ProductController {

	@RequestMapping("/showForm")
	public String showProductForm() {
		return "addProduct";
	}
	
	//RequestParam can used only with get method
	@RequestMapping(value="/addProduct")
	public String addProduct(@RequestParam("productName")String productName,
			@RequestParam("productId") Integer productId,
			@RequestParam("brand")String brand,
			@RequestParam("category")String category,
			@RequestParam("price")double price, Model model){
		
		// create a product object
		Product product =new Product();
		//set the values
		product.setProductName(productName);
		product.setProductId(productId);
		product.setBrand(brand);
		product.setCategory(category);
		product.setPrice(price);
		
		// add the product object to the model using addAttribute
		model.addAttribute("product", product);
		
		return "show";
		
	}
	
	// if the form field names and instance variable names are same then
	// no need of request mapping
	// Spring will identify the domain model and populate it
//	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
//	@RequestMapping(value="/addProduct")
//	public String addProduct(Product product,Model model) {
//		System.out.println(product);
//		model.addAttribute("nproduct", product);
//		return "show";
//	}
	
}
















