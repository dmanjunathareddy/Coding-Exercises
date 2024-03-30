package com.softgroup.hld.architectural.designpatterns.microsevices;

//Event-Sourced Aggregate
@Aggregate
public class OrderAggregate {
	@AggregateIdentifier
	private String orderId;

	@CommandHandler
	public OrderAggregate(CreateOrderCommand command) {
		// Handle command and publish events
	}

	// Event handlers...
}
