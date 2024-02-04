package com.softgroup.behavioral.designpatterns.visitor;

public class VisitorDesignPattern {

	public static void main(String[] args) {
        Element elementA = new ElementA();
        Element elementB = new ElementB();

        Visitor visitor = new ConcreteVisitor();

        elementA.accept(visitor);
        elementB.accept(visitor);
    }

}
