package com.softgroup.behavioral.designpatterns.command;

public class CommandDesignExample {

	public static void main(String[] args) {
		Light light = new Light();

		LightOnCommand lightOnCommand = new LightOnCommand(light);

		RemoteControl remote = new RemoteControl();
		remote.setCommand(lightOnCommand);

		remote.pressButton();
	}
}
