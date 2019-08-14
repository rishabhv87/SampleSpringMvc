package com.learnngrow.mvc.Beans;


public class Television{


	public int productId;
	
	public String brand;
	
	public String display;
	public float price;
	public String tvType;
	public boolean isColor;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getTvType() {
		return tvType;
	}

	public void setTvType(String tvType) {
		this.tvType = tvType;
	}

	
	
//	public Television (String brand,String display,float price, String tvType  ) {
//		this.brand= brand;
//		this.display= display;
//		this.price = price;
//		this.tvType= tvType;
//	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public boolean isColor() {
		return isColor;
	}

	public void setColor(boolean isColor) {
		this.isColor = isColor;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}


	
	
	



	
//	public String toString() {
//		String s = "ProductId : " + this.productId + ", price : "+ this.price 
//				+ " ,brand = " + this.brand ;
//		return s;
//	}
	
		
}

