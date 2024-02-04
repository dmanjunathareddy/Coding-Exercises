package com.softgroup.structural.designpatterns.bridge;

class Radio implements Device {
	@Override
	public void turnOn() {
		System.out.println("Turning on the Radio");
	}

	@Override
	public void turnOff() {
		System.out.println("Turning off the Radio");
	}

	@Override
	public void setChannel(int channel) {
		System.out.println("Setting Radio channel to " + channel);
	}
}