package com.softgroup.behavioral.designpatterns.cor;

public class  VicePresident implements Approver {
    private Approver next;

    @Override
    public void setNext(Approver next) {
        this.next = next;
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 10000) {
            System.out.println("Vice President approves purchase request #" + request.getRequestNumber());
        } else if (next != null) {
            next.processRequest(request);
        }
    }
}