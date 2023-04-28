package com.productapp.util;

public class Queries {
	public static final String INSERTQUERY="INSERT INTO PRODUCT(productName,brand,price,category) VALUES(?,?,?,?)";
	public static final String UPDATEQUERY = "UPDATE PRODUCT SET PRICE=? WHERE PRODUCTID=?";
	public static final String  DELETEQUERY = "DELETE FROM PRODUCT WHERE PRODUCTID =?";
	public static final String ALLPRODUCTS="SELECT * FROM PRODUCT";
	public static final String PRODUCTSBYBRAND="SELECT * FROM PRODUCT WHERE BRAND=?";
	public static final String PRODUCTSBYBRANDCAT="SELECT * FROM PRODUCT WHERE BRAND=? AND CATEGORY=?";
	public static final String PRODUCTSBYCAT="SELECT * FROM PRODUCT WHERE CATEGORY=?";
	public static final String PRODUCTSBYLESSPRICE="SELECT * FROM PRODUCT WHERE price <=?";
	public static final String PRODUCTBYID="SELECT * FROM PRODUCT WHERE PRODUCTID =?";
}
