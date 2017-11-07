package com.engieapp.buy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engieapp.buy.converc.ShopingCartFormToShopingCart;
import com.engieapp.buy.model.*;
import com.engieapp.buy.repository.ShopingCartRepository;

@Service
public class ShopingCartServiceImpl implements ShopingCartService {
	private ShopingCartRepository cartRepository;
	private ShopingCartFormToShopingCart cartFormToCart;
	
	@Autowired
	public ShopingCartServiceImpl(ShopingCartRepository cartRepository, ShopingCartFormToShopingCart cartFormToCart) {
		this.cartRepository = cartRepository;
		this.cartFormToCart = cartFormToCart;
	}
	
	@Override
	public ShopingCart getById(String id) {
		return cartRepository.findOne(id);
	}
	
	@Override
	public ShopingCart save(ShopingCart cart) {
		cartRepository.save(cart);
		return cart;
	}
	
	@Override
	public ShopingCart saveCartForm(ShopingCartForm cartForm) {
		ShopingCart car =save(cartFormToCart.convert(cartForm));
		return car;
	}	


}
