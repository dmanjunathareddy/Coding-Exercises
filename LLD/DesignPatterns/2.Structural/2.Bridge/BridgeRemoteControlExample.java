package com.softgroup.structural.designpatterns.bridge;

public class BridgeRemoteControlExample {
	public static void main(String[] args) {
		Device tv = new TV();
		Device radio = new Radio();

		RemoteControl basicRemote = new BasicRemoteControl(tv);
		RemoteControl advancedRemote = new AdvancedRemoteControl(radio);

		basicRemote.turnOn();
		basicRemote.setChannel(5);
		basicRemote.turnOff();

		System.out.println();

		advancedRemote.turnOn();
		advancedRemote.setChannel(7);
		((AdvancedRemoteControl) advancedRemote).mute();
		advancedRemote.turnOff();
	}
}
