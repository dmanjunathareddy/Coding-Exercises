package com.softgroup.language.java;

interface Vehicle {
    default void start() {
        System.out.println("Vehicle started");
    }
}

class Car implements Vehicle {
    // No need to implement the start() method
}

public class DefaultMethodInInterface {
    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // Output: Vehicle started
    }
}
