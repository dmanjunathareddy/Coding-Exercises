package com.softgroup.behavioral.designpatterns.cor;

/*The Chain of Responsibility pattern is let you pass requests along a chain of handlers. 
Upon receiving a request, each handler decides either to process the request or to pass it to
the next handler in the chain.*/
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver vicePresident = new VicePresident();
        Approver president = new President();

        // Set up the chain of responsibility
        manager.setNext(director);
        director.setNext(vicePresident);
        vicePresident.setNext(president);

        // Test the chain with purchase requests
        PurchaseRequest request1 = new PurchaseRequest(1, 800);
        PurchaseRequest request2 = new PurchaseRequest(2, 3500);
        PurchaseRequest request3 = new PurchaseRequest(3, 12000);

        manager.processRequest(request1);
        manager.processRequest(request2);
        manager.processRequest(request3);
    }
}