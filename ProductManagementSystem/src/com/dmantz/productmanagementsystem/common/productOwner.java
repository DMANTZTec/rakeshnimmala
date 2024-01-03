package com.dmantz.productmanagementsystem.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class productOwner {

	private int id;
	private List<Product> listOfProducts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public productOwner(int id, List<Product> listOfProducts) {
		super();
		this.id = id;
		this.listOfProducts = listOfProducts;
	}

	public productOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product getProductById(int id) {
		Product product = new Product();

//		for(Product p:listOfProducts) {
//			if(p.getProductId()==id) {
//				product.setProductId(p.getProductId());
//				product.setProductName(p.getProductName());
//				product.setListOfproductSKU(p.getListOfproductSKU());
//				
//			}
//		}

		listOfProducts.forEach(p -> {
			if (p.getProductId() == id) {
				product.setProductId(p.getProductId());
				product.setProductName(p.getProductName());
				product.setListOfproductSKU(p.getListOfproductSKU());
			}
		});

		return product;

	}

	public ProductSKU addProductSKU(int productId, ProductSKU prod) {
//		ProductSKU psk = new ProductSKU();

		// Product p=getProductById(productId);
		// p.getListOfproductSKU().add(prod);
//		return prod;
		getProductById(productId).getListOfproductSKU().add(prod);

		//////////////////

//		for (Product p : listOfProducts) {
//			if (p.getProductId() == productId) {
//				for (ProductSKU ps : p.getListOfproductSKU()) {
//					psk.setSkuId(prod.getSkuId());
//					psk.setSkuName(prod.getSkuName());
//					psk.setSkuPrice(prod.getSkuPrice());
//					
//					pl.add(productId, psk);
//
//				}
//			}
//		}

//		for (Product p : listOfProducts) {
//			if (p.getProductId() == productId) {
//				
//				p.getListOfproductSKU().add(prod);
//			
//			}
		// }
		return prod;
//
	}

	public List<Product> getListOfProducts1() {
//		List<Product> list = new ArrayList<Product>();
//		Product product = new Product();
//		listOfProducts.forEach(p -> {
//			product.setProductId(p.getProductId());
//			product.setProductName(p.getProductName());
//			product.setListOfproductSKU(p.getListOfproductSKU());
//		});
//		list.add(product);
//
//		return list;
		
		return getListOfProducts();

	}

	public List<ProductSKU> getListOfProductSKU() {
	    List<ProductSKU> list = new ArrayList<>();

	    // Assuming listOfProducts is a list of Product objects
	    listOfProducts.forEach(product -> {
	        // Assuming getListOfproductSKU() returns a list of ProductSKU objects
	        list.addAll(product.getListOfproductSKU());
	    });

	    return list;
	}
		


	}


