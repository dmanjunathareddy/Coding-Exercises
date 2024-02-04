package com.softgroup.behavioral.designpatterns.state;

public class GreenLight implements TrafficLightState {
	@Override
	public void displayState() {
		System.out.println("Green Light");
	}
}