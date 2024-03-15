package com.softgroup.hld.architectural.designpatterns.microsevices;

//Saga
@Saga
public class OrderSaga {
	@Autowired
	private CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent event) {
		// Handle event and send commands
	}

	// Other event handlers...
}
