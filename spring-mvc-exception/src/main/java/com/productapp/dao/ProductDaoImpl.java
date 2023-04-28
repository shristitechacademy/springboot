package com.productapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;
import com.productapp.util.Queries;

@Repository
public class ProductDaoImpl implements IProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Product product) {
		Object[] productArr = { product.getProductName(), product.getBrand(), product.getPrice(),
				product.getCategory() };
		jdbcTemplate.update(Queries.INSERTQUERY, productArr);
	}

	@Override
	public void update(int productId, double price) {
		jdbcTemplate.update(Queries.UPDATEQUERY, price, productId);
	}

	@Override
	public Product findById(int productId) {
		Product product = jdbcTemplate.queryForObject(Queries.PRODUCTBYID,new ProductMapper(),productId);
		return product;
	}

	@Override
	public void delete(int productId) {
		jdbcTemplate.update(Queries.DELETEQUERY, productId);

	}

	@Override
	public List<Product> findAllProducts() {
//		RowMapper<Product> productMapper = new ProductMapper();
		List<Product> products = jdbcTemplate.query(Queries.ALLPRODUCTS, new ProductMapper());
		return products;
	}

	@Override
	public List<Product> findByBrand(String brand) {
		List<Product> products = jdbcTemplate.query(Queries.PRODUCTSBYBRAND, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

				Product product = new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setPrice(rs.getDouble("price"));
				return product;
			}

		}, brand);
		return products;
	}

	@Override
	public List<Product> findByBrandAndCategory(String brand, String category) {
		List<Product> products = jdbcTemplate.query(Queries.PRODUCTSBYBRANDCAT, (rs, rowNum) -> {
			Product product = new Product();
			product.setProductId(rs.getInt("productId"));
			product.setProductName(rs.getString("productName"));
			product.setBrand(rs.getString("brand"));
			product.setCategory(rs.getString("category"));
			product.setPrice(rs.getDouble("price"));
			return product;
		}, brand, category);
		return products;
	}

	@Override
	public List<Product> findByLesserPrice(double price) {
		List<Product> products = jdbcTemplate.query(Queries.PRODUCTSBYLESSPRICE, new ProductMapper(),price);

		return products;
	}

	@Override
	public List<Product> findByCategory(String category) {
		List<Product> products = jdbcTemplate.query(Queries.PRODUCTSBYCAT, new ProductMapper(),category);
		return products;
	}

}
