package com.engieapp.buy.Controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.engieapp.buy.model.Cart;
import com.engieapp.buy.repository.ProductRepository;
import com.engieapp.buy.service.CalculatCartService;
import com.engieapp.buy.service.SessionIdService;

@RestController
public class CartController {
	@Autowired
	SessionIdService s;
	
	@Autowired
	private CalculatCartService calc;
	
	
	@PostMapping(value = "/createEndPoint",produces = "application/json",consumes = "application/json")
	public String createEndPoint(@RequestBody Cart cart,HttpServletRequest request) throws JSONException {
		double c = calc.Calculat(cart);
		String session =s.getuId().toString();
		
		JSONObject json =new JSONObject();
		String x = "{"+"checkout/"+session+"/";
		json.put("checkoutUrl", x);
		
		return json.toString();
	}
	

	@GetMapping(value = "/checkout/{id}")
    public String checkout(@RequestBody String id ,ModelMap model) {
		return id ;
	}
}
