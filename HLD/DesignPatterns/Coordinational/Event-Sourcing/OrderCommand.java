package com.softgroup.hld.coordination.designpatterns.eventsourcing;

public class OrderCommand {
	private final String orderId;
	private final String eventType;

	public OrderCommand(String orderId, String eventType) {
		this.orderId = orderId;
		this.eventType = eventType;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getEventType() {
		return eventType;
	}
}