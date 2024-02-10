package com.softgroup.hld.coordination.designpatterns.saga;

public class InventoryServiceImpl implements InventoryService {
	@Override
	public void reserveInventory(String orderId, String productId, int quantity) {
		// Logic to reserve inventory
		System.out.println("Inventory reserved for order: " + orderId);
	}

	@Override
	public void cancelInventoryReservation(String orderId, String productId, int quantity) {
		// Logic to cancel inventory reservation
		System.out.println("Inventory reservation canceled for order: " + orderId);
	}
}
