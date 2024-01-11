package com.softgroup.hld.coordination.designpatterns.eda;

public class EventListener1 implements EventListener {
	@Override
	public void onEvent(String event) {
		System.out.println("Listener 1: Event received - " + event);
	}
}