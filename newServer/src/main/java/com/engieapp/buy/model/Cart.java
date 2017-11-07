package com.engieapp.buy.model;

public class Cart {
	private String ios; 
	private String android;
	
	public Cart() {
		
	}
	
	
	public Cart(String ios,String android) {
		this.ios =ios;
		this.android=android;
	}
	
	public void setIos(String ios) {
		this.ios = ios;
	}


	public void setAndroid(String android) {
		this.android = android;
	}


	public String getIos() {
		return ios;
	}
	
	public String getAndroid() {
		return android;
	}

}
