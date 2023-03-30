package com.example.order.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ORDER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
    @Id
	private int id;
    private String name;
    private int quantity;
    private double price;

    //sample json payload
    // {
    //     "id": 1,
    //     "name": "Laptop",
    //     "quantity": 1,
    //     "price": 1000
    // }

}
