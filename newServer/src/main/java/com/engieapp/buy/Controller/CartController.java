package com.engieapp.buy.Controller;




import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.engieapp.buy.model.Cart;
import com.engieapp.buy.service.CalculatCartService;
import com.engieapp.buy.service.ShopingCartService;
import com.engieapp.buy.model.ShopingCart;
import com.engieapp.buy.model.ShopingCartForm;;

@CrossOrigin (maxAge = 3600)
@RestController
public class CartController {
	
	@Autowired
	private ShopingCartService cartService;
	
	@Autowired
	private CalculatCartService calc;
	
	
	@CrossOrigin
	@PostMapping(value = "/createEndPoint",produces = "application/json",consumes = "application/json")
	public String createEndPoint(@RequestBody Cart cart,HttpServletRequest request) throws JSONException {
		System.out.println(cart);
		ShopingCartForm cartForm = calc.Calculat(cart);	
		ShopingCart saveCart = cartService.saveCartForm(cartForm);
		
		String url = request.getRequestURL().toString();
		String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() ;

		JSONObject json =new JSONObject();
		String x = baseURL+"/checkout/"+saveCart.getId();
		json.put("checkoutUrl", x);
		
		return json.toString();
	}
	
	
	@CrossOrigin
	@GetMapping(value = "/checkout/{id}")
	 ModelAndView
	    index(@PathVariable String id)
	    {
	        ModelAndView mav = new ModelAndView("index");
	        mav.addObject("android",cartService.getById(id).getAndroidPrice());
	        mav.addObject("ios",cartService.getById(id).getIosPrice());
	        mav.addObject("total",cartService.getById(id).getTotal());
	        return mav;
	    }
	
	

}
