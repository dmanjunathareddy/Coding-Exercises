package com.softgroup.behavioral.designpatterns.cor;

public class President implements Approver {
	@Override
	public void setNext(Approver next) {
		// The President is the final approver, so there is no next handler.
	}

	@Override
	public void processRequest(PurchaseRequest request) {
		System.out.println("President approves purchase request #" + request.getRequestNumber());
	}
}