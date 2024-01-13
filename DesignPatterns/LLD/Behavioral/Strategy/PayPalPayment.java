package com.softgroup.behavioral.designpatterns.strategy;

public class PayPalPayment implements PaymentStrategy {
	private String email;

	public PayPalPayment(String email) {
		this.email = email;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using PayPal with email " + email);
	}
}