package com.softgroup.hld.coordination.designpatterns.eventsourcing;

public class OrderEvent {
	private final String orderId;
	private final String eventType;

	public OrderEvent(String orderId, String eventType) {
		this.orderId = orderId;
		this.eventType = eventType;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getEventType() {
		return eventType;
	}

	@Override
	public String toString() {
		return "OrderEvent [orderId=" + orderId + ", eventType=" + eventType + "]";
	}
	
}