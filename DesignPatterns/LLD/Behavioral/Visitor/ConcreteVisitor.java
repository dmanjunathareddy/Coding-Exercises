package com.softgroup.behavioral.designpatterns.visitor;

public class ConcreteVisitor implements Visitor {
	@Override
	public void visit(ElementA elementA) {
		System.out.println("Visitor is processing ElementA");
	}

	@Override
	public void visit(ElementB elementB) {
		System.out.println("Visitor is processing ElementB");
	}
}