package com.softgroup.behavioral.designpatterns.mediator;

public class MediatorPatternExample {
	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();

		ConcreteColleague colleague1 = new ConcreteColleague(mediator);
		ConcreteColleague colleague2 = new ConcreteColleague(mediator);

		mediator.addColleague(colleague1);
		mediator.addColleague(colleague2);

		colleague1.sendMessage("Hello, colleague2!");
		colleague2.sendMessage("Hi, colleague1!");
	}
}
