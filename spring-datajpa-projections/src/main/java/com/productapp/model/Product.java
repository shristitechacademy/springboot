package com.productapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
	@Column(name = "productname" , length=20)
	private String productName;
	@Id
	@GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1) // to create autoincrement ids
	@Column(name="productid")
	private Integer productId;
	private Double price;
	@Column(length=10)
	private String brand;
	@Column(length=20)
	private String category;
	public Product(String productName, double price, String brand, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}
	
	
	
	
	
}
