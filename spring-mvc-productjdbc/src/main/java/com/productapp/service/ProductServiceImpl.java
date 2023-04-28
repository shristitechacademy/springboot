package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.IProductDao;
import com.productapp.model.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	public void addProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public void updateProduct(int productId, double price) {
		productDao.update(productId, price);
	}

	@Override
	public Product getById(int productId) {
		return productDao.findById(productId);
	}

	@Override
	public void deleteProduct(int productId) {
		productDao.delete(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAllProducts();
	}

	@Override
	public List<Product> getByBrand(String brand) {
		return productDao.findByBrand(brand);
	}

	@Override
	public List<Product> getByBrandAndCategory(String brand, String category) {
		return productDao.findByBrandAndCategory(brand, category);
	}

	@Override
	public List<Product> getByLesserPrice(double price) {
		return productDao.findByLesserPrice(price);
	}

	@Override
	public List<Product> getByCategory(String category) {
		return productDao.findByCategory(category);
	}

}
