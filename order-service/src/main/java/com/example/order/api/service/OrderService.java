/**
 * 
 */
package com.example.order.api.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.api.common.Payment;
import com.example.order.api.common.TransactionRequest;
import com.example.order.api.common.TransactionResponse;
import com.example.order.api.entity.Order;
import com.example.order.api.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Phani
 *
 */
@Service
@RefreshScope
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;
	
	private Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
		String response = "";
		
		Order order = request.getOrder();
    	Payment payment = request.getPayment();
    	payment.setAmount(order.getPrice());
    	payment.setOrderId(order.getId());
    	
    	logger.info("OrderService request: ", new ObjectMapper().writeValueAsString(request));
    	// other service calls
    	Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL, payment, Payment.class);
    	logger.info("OrderService paymentResponse: ", new ObjectMapper().writeValueAsString(paymentResponse));

    	response = paymentResponse.getPaymentStatus().equalsIgnoreCase("success")?"Payment processing successfull and order palced":"There was a failure in payme   nt api";
    	
    	orderRepository.save(order);
    	
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
	}

}
