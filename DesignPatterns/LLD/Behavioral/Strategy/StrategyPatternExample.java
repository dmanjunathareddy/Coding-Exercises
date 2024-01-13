package com.softgroup.behavioral.designpatterns.strategy;

public class StrategyPatternExample {

	public static void main(String[] args) {
		// Client creates a shopping cart
		ShoppingCart cart = new ShoppingCart();

		// Client sets the payment strategy (Credit Card)
		PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
		cart.setPaymentStrategy(creditCardPayment);

		// Client checks out using the selected strategy
		cart.checkout(100);

		// Client changes the payment strategy (PayPal)
		PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
		cart.setPaymentStrategy(payPalPayment);

		// Client checks out again using the new strategy
		cart.checkout(50);

	}
}
