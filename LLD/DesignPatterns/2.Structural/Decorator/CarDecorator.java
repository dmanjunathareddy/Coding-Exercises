package com.softgroup.structural.designpatterns.decorator;

abstract class CarDecorator implements Car {
	protected Car decoratedCar;

	public CarDecorator(Car decoratedCar) {
		this.decoratedCar = decoratedCar;
	}

	@Override
	public double cost() {
		return decoratedCar.cost();
	}

	@Override
	public String getDescription() {
		return decoratedCar.getDescription();
	}
}