package com.engieapp.buy.converc;

import org.springframework.stereotype.Component;
import com.engieapp.buy.model.*;
import org.springframework.core.convert.converter.Converter;


@Component
public class ShopingCartFormToShopingCart implements Converter<ShopingCartForm,ShopingCart> {
	
	@Override
	public ShopingCart convert(ShopingCartForm cartForm) {
		ShopingCart cart  = new ShopingCart();
		if(cartForm.getId() !=null ) {
			cart.setId(cartForm.getId());
		}
		cart.setAndroidPrice(cartForm.getAndroidPrice());
		cart.setIosPrice(cartForm.getIosPrice());
		cart.setTotal(cartForm.getTotal());
		return cart;
	}
	
	
}
