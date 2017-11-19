package com.engieapp.buy.service;



import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engieapp.buy.model.Cart;
import com.engieapp.buy.model.ShopingCartForm;
import com.engieapp.buy.repository.ProductRepository;

@Service
public class CalculatCartService {
		
	@Autowired
	private ProductRepository productRepository;
	
	
	private double totalIos=0;
	private double totalAndroid=0;
	private double total=0;
	
	public CalculatCartService() {
		
	}

	public ShopingCartForm Calculat(Cart c) throws JSONException {
		
		totalIos=0;
		totalAndroid=0;
		total=0;
		//get the number of devices. 
		int iosNumber = Integer.parseInt(c.getIos());
		
		int androidNumber = Integer.parseInt(c.getAndroid());
		int ProductsNumber = androidNumber+iosNumber;

		

		//get the price of ios and android from the DB 
		double iosPrice =  Double.parseDouble(productRepository.findOne(1).getPrice());
		double androidPrice =  Double.parseDouble(productRepository.findOne(2).getPrice());
		
		
		
		//Calculate price of android and ios and total.
		int x;
		for (x=0;x<ProductsNumber;x++) {
			if (iosNumber>1) {
				totalIos =+ ((iosNumber-1)*iosPrice)*0.75+iosPrice;
			}
			if (androidNumber>1) {
				totalAndroid =+ ((androidNumber-1)*androidPrice)*0.75+androidPrice;
			}
			if (iosNumber==1){
				totalIos = iosPrice;
			}
			if (androidNumber==1){
				totalAndroid = androidPrice;
			}
			
		}
		total = totalIos+totalAndroid;

		
		ShopingCartForm shopingCartForm = new ShopingCartForm();
		shopingCartForm.setAndroidPrice(totalAndroid);
		shopingCartForm.setIosPrice(totalIos);
		shopingCartForm.setTotal(total);
		
		return shopingCartForm;
		
		}
		
	} 
	
	


