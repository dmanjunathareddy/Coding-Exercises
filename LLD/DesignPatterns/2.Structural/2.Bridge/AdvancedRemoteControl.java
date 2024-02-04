package com.softgroup.structural.designpatterns.bridge;

public class AdvancedRemoteControl extends RemoteControl {
	public AdvancedRemoteControl(Device device) {
		super(device);
	}

	@Override
	void turnOn() {
		System.out.print("Advanced remote control: ");
		device.turnOn();
	}

	@Override
	void turnOff() {
		System.out.print("Advanced remote control: ");
		device.turnOff();
	}

	@Override
	void setChannel(int channel) {
		System.out.print("Advanced remote control: ");
		device.setChannel(channel);
	}

	public void mute() {
		System.out.println("Advanced remote control: Muting the device");
	}
}