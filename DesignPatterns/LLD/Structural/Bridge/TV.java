package com.softgroup.structural.designpatterns.bridge;

//Concrete Implementors
class TV implements Device {
	@Override
	public void turnOn() {
		System.out.println("Turning on the TV");
	}

	@Override
	public void turnOff() {
		System.out.println("Turning off the TV");
	}

	@Override
	public void setChannel(int channel) {
		System.out.println("Setting TV channel to " + channel);
	}
}
