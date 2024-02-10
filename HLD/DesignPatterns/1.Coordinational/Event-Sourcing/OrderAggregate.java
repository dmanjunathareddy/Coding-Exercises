package com.softgroup.hld.coordination.designpatterns.eventsourcing;

import java.util.ArrayList;
import java.util.List;

public class OrderAggregate {

	private final String orderId;
	private final List<OrderEvent> events;

	public OrderAggregate(String orderId) {
		this.orderId = orderId;
		this.events = new ArrayList<>();
	}

	// Apply an event to update the state
	public void applyEvent(OrderEvent event) {
		events.add(event);
		// Apply business logic based on the event type to update the state
		// For simplicity, just printing the event details
		System.out.println("Event Applied: " + event.getEventType() + " for Order ID: " + orderId);
	}

	public String getOrderId() {
		return orderId;
	}

	public List<OrderEvent> getEvents() {
		return new ArrayList<>(events);
	}
}
