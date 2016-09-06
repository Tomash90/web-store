package com.packt.webstore.exception;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -594354952342299997L;
	String productId;
	public ProductNotFoundException(String productId){
		this.productId=productId;
	}
	public String getProductId(){
		return productId;
	}
}

