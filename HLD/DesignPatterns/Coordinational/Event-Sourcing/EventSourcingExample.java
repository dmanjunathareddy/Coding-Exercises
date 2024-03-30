package com.softgroup.hld.coordination.designpatterns.eventsourcing;

public class EventSourcingExample {
	public static void main(String[] args) {
		// Create an OrderAggregate
		OrderAggregate orderAggregate = new OrderAggregate("123");

		// Create a CommandHandler with the OrderAggregate
		OrderCommandHandler commandHandler = new OrderCommandHandler(orderAggregate);

		// Process commands to apply events and update the state
		commandHandler.processCommand(new OrderCommand("123", "ORDER_PLACED"));
		commandHandler.processCommand(new OrderCommand("123", "ORDER_SHIPPED"));

		// Retrieve the current state of the OrderAggregate by replaying events
		System.out.println("\nCurrent State of Order ID 123:");
		System.out.println("Order ID: " + orderAggregate.getOrderId());
		System.out.println("Events: " + orderAggregate.getEvents());
	}
}
