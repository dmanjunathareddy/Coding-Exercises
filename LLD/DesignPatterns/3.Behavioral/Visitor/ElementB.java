package com.softgroup.behavioral.designpatterns.visitor;

public class ElementB implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}