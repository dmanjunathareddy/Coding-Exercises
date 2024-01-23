package com.softgroup.behavioral.designpatterns.visitor;

public class ElementA implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}