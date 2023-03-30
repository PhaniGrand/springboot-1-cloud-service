/**
 * 
 */
package com.example.order.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.api.common.Payment;
import com.example.order.api.common.TransactionRequest;
import com.example.order.api.common.TransactionResponse;
import com.example.order.api.entity.Order;
import com.example.order.api.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Phani
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
	private OrderService orderService;

    @PostMapping("/saveOrder")
    public TransactionResponse saveOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {
    
    	return orderService.saveOrder(request);
    }
    
    
    
}
