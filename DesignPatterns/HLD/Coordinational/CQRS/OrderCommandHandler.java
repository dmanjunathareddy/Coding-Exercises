package com.softgroup.behavioral.designpatterns.cqrs;

public class OrderCommandHandler {
    void handleCreateOrder(CreateOrderCommand command) {
        // Perform validation and business logic for creating an order
        // Update the write database model
        System.out.println("Order created for product " + command.getProductId() + " with quantity " + command.getQuantity());
    }
}