package com.engieapp.buy.Controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engieapp.buy.repository.ProductRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;

	@CrossOrigin
	@GetMapping(value = "/buy-obd/get-prices" ,produces = "application/json")
	public String getAll() throws JSONException{
		JSONObject json =new JSONObject();
		double iosPrice =  Double.parseDouble(productRepository.findOne(1).getPrice());
		double androidPrice =  Double.parseDouble(productRepository.findOne(2).getPrice());
		
		json.put("ios", iosPrice);
		json.put("android", androidPrice);
		
		return json.toString();
	}
	
}