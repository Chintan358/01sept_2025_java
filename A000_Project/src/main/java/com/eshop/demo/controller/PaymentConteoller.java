package com.eshop.demo.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class PaymentConteoller {
	
	
		@GetMapping("/payment")
		public ResponseEntity<String> makepayment(@RequestParam("amount") int amt) throws RazorpayException
		{
				
				
				RazorpayClient razorpay = new RazorpayClient("rzp_test_STKkFlTZJmOAWQ", "vDoIj5fckJDvYFBTwZAB18fv");
				JSONObject orderRequest = new JSONObject();
				orderRequest.put("amount",amt*100); // Amount is in currency subunits. 
				orderRequest.put("currency","INR");
				orderRequest.put("receipt", "receipt#1");
				JSONObject notes = new JSONObject();
				notes.put("notes_key_1","Tea, Earl Grey, Hot");
				orderRequest.put("notes",notes);
				Order order = razorpay.orders.create(orderRequest);
				return ResponseEntity.ok(order.toJson().toString());
			
				
				
		}
}
