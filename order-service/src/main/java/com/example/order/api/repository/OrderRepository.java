/**
 * 
 */
package com.example.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.api.entity.Order;

/**
 * @author Phani
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
