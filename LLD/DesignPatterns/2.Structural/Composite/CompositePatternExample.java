package com.softgroup.structural.designpatterns.composite;

//Client code
public class CompositePatternExample {
	public static void main(String[] args) {
		// Creating leaf shapes
		Circle circle = new Circle();
		Square square = new Square();

		// Creating composite shape
		CompositeShape composite = new CompositeShape();
		composite.addShape(circle);
		composite.addShape(square);

		// Drawing individual shapes
		circle.draw();
		square.draw();

		// Drawing composite shape
		composite.draw();
	}
}