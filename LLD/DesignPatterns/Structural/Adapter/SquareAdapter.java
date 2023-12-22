package com.softgroup.structural.designpatterns.adapter;

//Adapter: SquareAdapter
public class SquareAdapter implements Shape {
	private ExistingSquare square;

	public SquareAdapter(ExistingSquare square) {
		this.square = square;
	}

	@Override
	public double getArea() {
		// Use the existing Square class to calculate the area
		return square.calculateArea();
	}
}
