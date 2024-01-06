package com.softgroup.behavioral.designpatterns.cor;

public interface Approver {
	void setNext(Approver next);

	void processRequest(PurchaseRequest request);
}