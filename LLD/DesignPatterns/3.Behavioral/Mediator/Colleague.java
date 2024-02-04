package com.softgroup.behavioral.designpatterns.mediator;

public interface Colleague {
	void sendMessage(String message);

	void receiveMessage(String message);
}