package com.engieapp.buy.service;

import com.engieapp.buy.model.*;

public interface ShopingCartService {
	ShopingCart getById (String id);
	ShopingCart save(ShopingCart cart);
	ShopingCart saveCartForm (ShopingCartForm cartForm);

}
