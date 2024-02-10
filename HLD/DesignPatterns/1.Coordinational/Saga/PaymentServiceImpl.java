package com.softgroup.hld.coordination.designpatterns.saga;

public class PaymentServiceImpl implements PaymentService {
	@Override
	public void processPayment(String orderId, double amount) {
		// Logic to process payment
		System.out.println("Payment processed for order: " + orderId);
	}

	@Override
	public void cancelPayment(String orderId, double amount) {
		// Logic to cancel payment
		System.out.println("Payment canceled for order: " + orderId);
	}
}