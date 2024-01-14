package com.softgroup.hld.coordination.designpatterns.eventsourcing;

public class OrderCommandHandler {
	private final OrderAggregate orderAggregate;

	public OrderCommandHandler(OrderAggregate orderAggregate) {
		this.orderAggregate = orderAggregate;
	}

	// Process a command and apply an event
	public void processCommand(OrderCommand command) {
		OrderEvent event = new OrderEvent(command.getOrderId(), command.getEventType());
		orderAggregate.applyEvent(event);
	}
}