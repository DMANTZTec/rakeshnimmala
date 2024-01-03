package com.dmantz.productmanagementsystem.common;

import java.util.ArrayList;

public class ProductSKU {
	
	private int skuId;
	private String skuName;
	private int skuPrice;
	public int getSkuId() {
		return skuId;
	}
	public void setSkuId(int skuId) {
		this.skuId = skuId;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public int getSkuPrice() {
		return skuPrice;
	}
	public void setSkuPrice(int skuPrice) {
		this.skuPrice = skuPrice;
	}
	@Override
	public String toString() {
		return "ProductSKU [skuId=" + skuId + ", skuName=" + skuName + ", skuPrice=" + skuPrice + "]";
	}
	public ProductSKU(int skuId, String skuName, int skuPrice) {
		super();
		this.skuId = skuId;
		this.skuName = skuName;
		this.skuPrice = skuPrice;
	}
	public ProductSKU() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
