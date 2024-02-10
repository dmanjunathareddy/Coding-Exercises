package com.softgroup.hld.coordination.designpatterns.saga;

public class OrderSagaOrchestrator {
    private final OrderService orderService;
    private final InventoryService inventoryService;
    private final PaymentService paymentService;

    public OrderSagaOrchestrator(OrderService orderService, InventoryService inventoryService, PaymentService paymentService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    public void processOrderSaga(String orderId, String productId, int quantity, double amount) {
        try {
            // Step 1: Place Order
            orderService.placeOrder(orderId, productId, quantity);

            // Step 2: Reserve Inventory
            inventoryService.reserveInventory(orderId, productId, quantity);

            // Step 3: Process Payment
            paymentService.processPayment(orderId, amount);

            System.out.println("Order processing completed successfully.");
        } catch (Exception e) {
            // If any step fails, initiate compensation actions
            cancelOrderSaga(orderId, productId, quantity, amount);
            System.out.println("Order processing failed. Compensating actions initiated.");
        }
    }

    private void cancelOrderSaga(String orderId, String productId, int quantity, double amount) {
        // Step 3: Cancel Payment
        paymentService.cancelPayment(orderId, amount);

        // Step 2: Cancel Inventory Reservation
        inventoryService.cancelInventoryReservation(orderId, productId, quantity);

        // Step 1: No need to cancel order placement in this example

        System.out.println("Compensating actions completed.");
    }
}