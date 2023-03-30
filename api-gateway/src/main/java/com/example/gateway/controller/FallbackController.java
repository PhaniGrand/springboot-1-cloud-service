/**
 * 
 */
package com.example.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Phani
 *
 */
@RestController
public class FallbackController {
	
	@RequestMapping("orderFallBack")
	public String orderServiceFallback(){
		return "Order-Service is not responding. Please try again later.";
	}

	@RequestMapping	("paymentFallBack")
	public String paymentServiceFallback(){
		return 	"Payment-Service is not responding. Please try again later.";
	}
}
