package com.softgroup.structural.designpatterns.bridge;

//Refined Abstraction
class BasicRemoteControl extends RemoteControl {
	public BasicRemoteControl(Device device) {
		super(device);
	}

	@Override
	void turnOn() {
		System.out.print("Basic remote control: ");
		device.turnOn();
	}

	@Override
	void turnOff() {
		System.out.print("Basic remote control: ");
		device.turnOff();
	}

	@Override
	void setChannel(int channel) {
		System.out.print("Basic remote control: ");
		device.setChannel(channel);
	}
}