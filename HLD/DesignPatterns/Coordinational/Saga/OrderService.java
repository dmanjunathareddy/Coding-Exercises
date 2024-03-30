package com.softgroup.hld.coordination.designpatterns.saga;

public interface OrderService {
    void placeOrder(String orderId, String productId, int quantity);
} 