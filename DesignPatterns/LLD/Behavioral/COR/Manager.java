package com.softgroup.behavioral.designpatterns.cor;

public class Manager implements Approver {
	private Approver next;

	@Override
	public void setNext(Approver next) {
		this.next = next;
	}

	@Override
	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() <= 1000) {
			System.out.println("Manager approves purchase request #" + request.getRequestNumber());
		} else if (next != null) {
			next.processRequest(request);
		}
	}
}