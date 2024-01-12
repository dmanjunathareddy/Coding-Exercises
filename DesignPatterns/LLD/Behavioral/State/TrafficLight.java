package com.softgroup.behavioral.designpatterns.state;

public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        // Initial state is Red
        this.state = new RedLight();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void displayState() {
        state.displayState();
    }
}
