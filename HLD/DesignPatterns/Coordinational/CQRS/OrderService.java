package com.softgroup.hld.coordination.designpatterns.cqrs;

public class OrderService {
	private final OrderCommandHandler commandHandler;
	private final OrderQueryHandler queryHandler;

	public OrderService(OrderCommandHandler commandHandler, OrderQueryHandler queryHandler) {
		this.commandHandler = commandHandler;
		this.queryHandler = queryHandler;
	}

	// Command operation to create a new order
	void createOrder(CreateOrderCommand command) {
		commandHandler.handleCreateOrder(command);
	}

	// Query operation to fetch order details
	Order getOrderDetails(String orderId) {
		return queryHandler.getOrderDetails(orderId);
	}
}