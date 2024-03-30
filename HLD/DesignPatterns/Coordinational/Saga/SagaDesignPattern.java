package com.softgroup.hld.coordination.designpatterns.saga;

public class SagaDesignPattern {

	public static void main(String[] args) {
		OrderService orderService = new OrderServiceImpl();
		InventoryService inventoryService = new InventoryServiceImpl();
		PaymentService paymentService = new PaymentServiceImpl();

		OrderSagaOrchestrator orchestrator = new OrderSagaOrchestrator(orderService, inventoryService, paymentService);

		// Example: Successful order processing
		orchestrator.processOrderSaga("123", "ABC123", 2, 100.0);

		System.out.println("\n----------------------\n");

		// Example: Failed order processing (compensation triggered)
		orchestrator.processOrderSaga("456", "XYZ456", 3, 150.0);

	}
}