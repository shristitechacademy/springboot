package com.productapp.dao;

import java.util.List;

import com.productapp.model.Product;

public interface IProductDao {

	void save(Product product); 
	void update(int productId, double price);
	
	Product findById(int productId); 
	void delete(int productId);
	
	List<Product> findAllProducts();
	List<Product> findByBrand(String brand);
	List<Product> findByBrandAndCategory(String brand,String category);
	List<Product> findByLesserPrice(double price);
	List<Product> findByCategory(String category);
}
