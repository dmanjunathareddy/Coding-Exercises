package com.softgroup.hld.coordination.designpatterns.cqrs;

public class CQRSExample {
    public static void main(String[] args) {
        // Instantiate command and query handlers
        OrderCommandHandler commandHandler = new OrderCommandHandler();
        OrderQueryHandler queryHandler = new OrderQueryHandler();

        // Instantiate the application service with the handlers
        OrderService orderService = new OrderService(commandHandler, queryHandler);

        // Perform a command operation to create a new order
        CreateOrderCommand createOrderCommand = new CreateOrderCommand();
        createOrderCommand.setProductId("P001");
        createOrderCommand.setQuantity(5);
        orderService.createOrder(createOrderCommand);

        // Perform a query operation to fetch order details
        Order orderDetails = orderService.getOrderDetails("O123");
        System.out.println("Fetched order details: " + orderDetails);
    }
}
