package com.softgroup.behavioral.designpatterns.visitor;

public interface Element {
	void accept(Visitor visitor);
}