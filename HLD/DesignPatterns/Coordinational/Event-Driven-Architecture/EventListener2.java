package com.softgroup.hld.coordination.designpatterns.eda;

public class EventListener2 implements EventListener {
	@Override
	public void onEvent(String event) {
		System.out.println("Listener 2: Event received - " + event);
	}
}