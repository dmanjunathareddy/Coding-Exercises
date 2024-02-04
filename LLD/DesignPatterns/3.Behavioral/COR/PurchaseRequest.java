package com.softgroup.behavioral.designpatterns.cor;

public class PurchaseRequest {
	private final int requestNumber;
	private final double amount;

	public PurchaseRequest(int requestNumber, double amount) {
		this.requestNumber = requestNumber;
		this.amount = amount;
	}

	public int getRequestNumber() {
		return requestNumber;
	}

	public double getAmount() {
		return amount;
	}
}