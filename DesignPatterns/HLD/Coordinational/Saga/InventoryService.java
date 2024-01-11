package com.softgroup.hld.coordination.designpatterns.saga;

public interface InventoryService {
	void reserveInventory(String orderId, String productId, int quantity);

	void cancelInventoryReservation(String orderId, String productId, int quantity);
}