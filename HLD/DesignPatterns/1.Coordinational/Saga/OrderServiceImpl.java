package com.softgroup.hld.coordination.designpatterns.saga;

public class OrderServiceImpl implements OrderService {
	@Override
	public void placeOrder(String orderId, String productId, int quantity) {
		// Logic to place an order
		System.out.println("Order placed: " + orderId);
	}
}