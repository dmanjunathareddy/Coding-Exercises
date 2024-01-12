package com.softgroup.behavioral.designpatterns.state;

public class RedLight implements TrafficLightState {
	@Override
	public void displayState() {
		System.out.println("Red Light");
	}
}