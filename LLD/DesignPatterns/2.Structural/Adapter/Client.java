package com.softgroup.structural.designpatterns.adapter;

//Client Code
public class Client {
	public static void main(String[] args) {
		// Using the SquareAdapter to adapt Square to Shape
		ExistingSquare square = new ExistingSquare();
		Shape shapeAdapter = new SquareAdapter(square);

		// Client can now use the Shape interface
		double area = shapeAdapter.getArea();
		System.out.println("Area: " + area); // Outputs: Area: 25.0
	}
}
