package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {
	
	void addProduct(Product product); 
	
	void updateProduct(int productId, double price);
	
	Product getById(int productId); 
	void deleteProduct(int productId);
	
	List<Product> getAllProducts();
	List<Product> getByBrand(String brand);
	List<Product> getByBrandAndCategory(String brand,String category);
	List<Product> getByLesserPrice(double price);
	List<Product> getByCategory(String category);

}
