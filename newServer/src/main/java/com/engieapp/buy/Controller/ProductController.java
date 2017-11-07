package com.engieapp.buy.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engieapp.buy.model.Products;
import com.engieapp.buy.repository.ProductRepository;


@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;

	
	@GetMapping(value = "/buy-obd/get-prices")
	public List<Products> getAll(){
		return productRepository.findAll();
	}
	
}