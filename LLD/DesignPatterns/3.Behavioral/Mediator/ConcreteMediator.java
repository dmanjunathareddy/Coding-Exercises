package com.softgroup.behavioral.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
	private List<Colleague> colleagues;

	public ConcreteMediator() {
		this.colleagues = new ArrayList<>();
	}

	public void addColleague(Colleague colleague) {
		colleagues.add(colleague);
	}

	@Override
	public void sendMessage(Colleague colleague, String message) {
		for (Colleague c : colleagues) {
			if (c != colleague) {
				c.receiveMessage(message);
			}
		}
	}
}