package com.softgroup.structural.designpatterns.decorator;

class BasicCar implements Car {
	@Override
	public double cost() {
		return 20000.0; // Basic cost of a basic car
	}

	@Override
	public String getDescription() {
		return "Basic Car";
	}
}