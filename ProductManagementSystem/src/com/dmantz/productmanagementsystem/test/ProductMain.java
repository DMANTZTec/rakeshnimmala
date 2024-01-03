package com.dmantz.productmanagementsystem.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dmantz.productmanagementsystem.common.Product;
import com.dmantz.productmanagementsystem.common.ProductSKU;
import com.dmantz.productmanagementsystem.common.productOwner;

public class ProductMain {

	public static void main(String[] args) {

		ProductSKU sku = new ProductSKU(1, "HP", 2200);
		ProductSKU sku1 = new ProductSKU(2, "RedMe", 1500);

		ProductSKU sku2 = new ProductSKU(3, "Audi", 5500);
		List<ProductSKU> psku=new ArrayList<ProductSKU>();
		
		
		psku.add(sku);
		psku.add(sku1);
		psku.add(sku2);

	List<Product> plist = new ArrayList<>();
	ArrayList<ProductSKU> list1=new ArrayList<>();
	list1.add(sku);
	
	ArrayList<ProductSKU> list2=new ArrayList<>();
	list2.add(sku1);
	ArrayList<ProductSKU> list3=new ArrayList<>();
	list3.add(sku2);


		Product p = new Product(1, "LapTop",list1);
		Product p1 = new Product(2, "Mobile",list2);
		Product p2 = new Product(3, "Car",list3);
		
		Product pro=new Product();
		

		plist.add(p);
		plist.add(p1);
		plist.add(p2);
		
		productOwner po=new productOwner();
		po.setId(1);
		po.setListOfProducts(plist);
//		System.out.println(po.getProductById(1));
		
		ProductSKU p11=new ProductSKU();
		p11.setSkuId(6);
		p11.setSkuName("Dell");
		p11.setSkuPrice(45000);
	
	//System.out.println(po.addProductSKU(1, p11));
		
	//	System.out.println(po.getProductById(1));
		
	//System.out.println(po.getListOfProducts());
		System.out.println(po.getListOfProductSKU());

	
		
	

	}
	

	
}
