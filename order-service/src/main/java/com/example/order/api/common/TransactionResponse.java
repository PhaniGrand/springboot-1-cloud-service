/**
 * 
 */
package com.example.order.api.common;

import com.example.order.api.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Phani
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

}
