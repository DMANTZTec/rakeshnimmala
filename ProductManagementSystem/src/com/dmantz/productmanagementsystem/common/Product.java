package com.dmantz.productmanagementsystem.common;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int productId;
	private String productName;
	private ArrayList<ProductSKU> listOfproductSKU;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ArrayList<ProductSKU> getListOfproductSKU() {
		return listOfproductSKU;
	}
	public void setListOfproductSKU(ArrayList<ProductSKU> listOfproductSKU) {
		this.listOfproductSKU = listOfproductSKU;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", listOfproductSKU="
				+ listOfproductSKU + "]";
	}
	
	public Product(int productId, String productName, ArrayList<ProductSKU> listOfproductSKU) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.listOfproductSKU = listOfproductSKU;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
