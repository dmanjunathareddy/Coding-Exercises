package com.softgroup.behavioral.designpatterns.state;

public class YellowLight implements TrafficLightState {
	@Override
	public void displayState() {
		System.out.println("Yellow Light");
	}
}