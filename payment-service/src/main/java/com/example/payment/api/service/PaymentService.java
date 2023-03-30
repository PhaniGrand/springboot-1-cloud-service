/**
 * 
 */
package com.example.payment.api.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.api.entity.Payment;
import com.example.payment.api.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Phani
 *
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    
	private Logger logger = LoggerFactory.getLogger(PaymentService.class);


    public Payment savePayment(Payment payment) throws JsonProcessingException {
        // set random transaction id
        payment.setTransactionId(UUID.randomUUID().toString());
        // set payment status
        payment.setPaymentStatus(paymentStatus());
        
    	logger.info("PaymentService request: ", new ObjectMapper().writeValueAsString(payment));

       
    	return paymentRepository.save(payment);
    }

    public String paymentStatus() {
        // 3rd party payment gateway
        return new Random().nextBoolean() ? "success" : "failure";
    }

}
