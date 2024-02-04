package com.softgroup.structural.designpatterns.decorator;

public class DecoratorPatternExample {
	public static void main(String[] args) {
		/*
		 * Imagine you have a basic car, and you want to add additional features like
		 * GPS, leather seats, and a sunroof without creating a separate class for every
		 * possible combination. The Decorator pattern can help with this.
		 */
		// Creating a basic car
		Car basicCar = new BasicCar();
		System.out.println("Cost: $" + basicCar.cost() + ", Description: " + basicCar.getDescription());

		// Decorating with GPS
		Car carWithGPS = new GPSDecorator(basicCar);
		System.out.println("Cost: $" + carWithGPS.cost() + ", Description: " + carWithGPS.getDescription());

		// Decorating with leather seats
		Car luxuryCar = new LeatherSeatsDecorator(carWithGPS);
		System.out.println("Cost: $" + luxuryCar.cost() + ", Description: " + luxuryCar.getDescription());
	}
}