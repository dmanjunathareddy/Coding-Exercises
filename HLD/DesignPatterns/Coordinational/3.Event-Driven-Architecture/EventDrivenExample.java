package com.softgroup.hld.coordination.designpatterns.eda;

public class EventDrivenExample {
    public static void main(String[] args) {
        // Create an Event Publisher
        EventPublisher eventPublisher = new EventPublisher();

        // Create Event Listeners
        EventListener listener1 = new EventListener1();
        EventListener listener2 = new EventListener2();

        // Register Event Listeners with the Event Publisher
        eventPublisher.addListener(listener1);
        eventPublisher.addListener(listener2);

        // Simulate an event (e.g., user action)
        String event = "User clicked a button";

        // Notify all registered listeners about the event
        eventPublisher.notifyListeners(event);
    }
}