package com.softgroup.structural.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

 public class CompositeShape implements Shape {
	private List<Shape> shapes = new ArrayList<>();

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	@Override
	public void draw() {
		System.out.println("Drawing Composite Shape");
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
}