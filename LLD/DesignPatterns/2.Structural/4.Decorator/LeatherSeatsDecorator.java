package com.softgroup.structural.designpatterns.decorator;

public class LeatherSeatsDecorator extends CarDecorator {
	public LeatherSeatsDecorator(Car decoratedCar) {
		super(decoratedCar);
	}

	@Override
	public double cost() {
		return super.cost() + 1000.0;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", with Leather Seats";
	}
}