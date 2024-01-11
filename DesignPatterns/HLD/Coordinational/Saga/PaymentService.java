package com.softgroup.hld.coordination.designpatterns.saga;

public interface PaymentService {
	void processPayment(String orderId, double amount);

	void cancelPayment(String orderId, double amount);
}