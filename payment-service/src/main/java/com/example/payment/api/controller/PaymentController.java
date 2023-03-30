/**
 * 
 */
package com.example.payment.api.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.api.entity.Payment;
import com.example.payment.api.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Phani
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/savePayment")
	public Payment savePayment(@RequestBody Payment payment) throws JsonProcessingException {
		return paymentService.savePayment(payment);
	}

}
