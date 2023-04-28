package com.productapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.productapp.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		String name = rs.getString("productName");
//		String brand = rs.getString("brand");
		String category = rs.getString("category");
		double price = rs.getDouble("price");
		Integer productId = rs.getInt("productId");
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(name);
		product.setBrand(rs.getString("brand"));
		product.setCategory(category);
		product.setPrice(price);
		return product;
	}

}
