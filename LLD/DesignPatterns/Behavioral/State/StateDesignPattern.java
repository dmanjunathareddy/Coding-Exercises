package com.softgroup.behavioral.designpatterns.state;

public class StateDesignPattern {

	
	public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // Initial state
        trafficLight.displayState();

        // Change state to Yellow
        trafficLight.setState(new YellowLight());
        trafficLight.displayState();

        // Change state to Green
        trafficLight.setState(new GreenLight());
        trafficLight.displayState();

        // Change state back to Red
        trafficLight.setState(new RedLight());
        trafficLight.displayState();
	}
}
