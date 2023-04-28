package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;

@Controller
public class ProductController {
	
	public IProductService productService;
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/")
	public String home(ModelMap map) {
		List<Product> products = productService.getAllProducts();
		map.addAttribute("products", products);
		return "home";
	}

	@RequestMapping("/search")
	public String getByBrand(@RequestParam("brand")String brand, ModelMap map) {
		List<Product> products = productService.getByBrand(brand);
		map.addAttribute("products", products);
		return "home";
	}
	@RequestMapping("/addProduct")
	public String addProduct(Product product,ModelMap map) {
		productService.addProduct(product);
		map.addAttribute("result", "product added");
		return "admin";
		
	}
	
	@RequestMapping("/editProduct")
	public String editProduct(@RequestParam("productId")int productId, ModelMap map) {
		Product product = productService.getById(productId);
		map.addAttribute("product", product);
		return "updateForm";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@RequestParam("productId")int productId,
			@RequestParam("price")double price,
			ModelMap map) {
		productService.updateProduct(productId, price);
		map.addAttribute("result", "product updated");
		return "admin";
		
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId")int productId, ModelMap map) {
		productService.deleteProduct(productId);
		map.addAttribute("result", "product deleted");
		return "admin";
	}
	
	
	// handler method
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFound(ProductNotFoundException e) {
		// process the exception
		ModelAndView modelView = new ModelAndView("home","errorMessage", e.getMessage());
		return modelView;
	}
	
}






