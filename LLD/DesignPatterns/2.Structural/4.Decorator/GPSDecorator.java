package com.softgroup.structural.designpatterns.decorator;

public class GPSDecorator extends CarDecorator {
	public GPSDecorator(Car decoratedCar) {
		super(decoratedCar);
	}

	@Override
	public double cost() {
		return super.cost() + 500.0; // Additional cost for GPS
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", with GPS";
	}
}