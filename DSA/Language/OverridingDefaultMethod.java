package com.softgroup.language.java;

interface Vehicle1 {
    default void start() {
        System.out.println("Vehicle started");
    }
}

class Car1 implements Vehicle1 {
    @Override
    public void start() {
        System.out.println("Car started");
    }
}

public class OverridingDefaultMethod {
    public static void main(String[] args) {
        Car1 car = new Car1();
        car.start(); // Output: Car started
    }
}
