package com.engieapp.buy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="product")
	private String product;
	
	@Column(name="price")
	private String price;
	
	public Products() {
		
	}

	public Integer getId() {
		return id;
	}

	public String getProduct() {
		return product;
	}

	public String getPrice() {
		return price;
	}

	
}
