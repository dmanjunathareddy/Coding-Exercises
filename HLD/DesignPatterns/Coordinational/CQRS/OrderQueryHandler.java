package com.softgroup.hld.coordination.designpatterns.cqrs;

public class OrderQueryHandler {
    Order getOrderDetails(String orderId) {
        // Fetch order details from the read database model
        // Return the order object
        System.out.println("Fetching order details for order ID: " + orderId);
        return new Order();
    }
}