package com.softgroup.behavioral.designpatterns.mediator;

public class ConcreteColleague implements Colleague {
	private Mediator mediator;

	public ConcreteColleague(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void sendMessage(String message) {
		System.out.println("Sending message: " + message);
		mediator.sendMessage(this, message);
	}

	@Override
	public void receiveMessage(String message) {
		System.out.println("Received message: " + message);
	}
}