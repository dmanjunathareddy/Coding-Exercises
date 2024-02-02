package com.softgroup.lld.pizzabookingsystem;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
	int orderId;
	Customer customer;
	List<Pizza> pizzas;
	LocalDateTime orderTime;
	String status;

	// Constructors, getters, and setters

	double calculateTotalPrice() {
		return 0;
		// Implementation
	}

	void updateStatus(String newStatus) {
		// Implementation
	}
}