package com.softgroup.behavioral.designpatterns.observer;

public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create ConcreteSubject
        ConcreteSubject subject = new ConcreteSubject();

        // Create ConcreteObservers
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");

        // Register observers with the subject
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Notify observers of a state change
        subject.notifyObservers("State change: Event 1");

        // Remove one observer
        subject.removeObserver(observer1);

        // Notify remaining observer
        subject.notifyObservers("State change: Event 2");
    }
}
