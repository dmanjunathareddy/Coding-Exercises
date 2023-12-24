package com.softgroup.structural.designpatterns.bridge;

//Abstraction
abstract class RemoteControl {
	protected Device device;

	protected RemoteControl(Device device) {
		this.device = device;
	}

	abstract void turnOn();

	abstract void turnOff();

	abstract void setChannel(int channel);
}