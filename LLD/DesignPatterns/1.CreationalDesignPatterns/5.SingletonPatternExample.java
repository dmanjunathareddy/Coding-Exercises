package com.softgroup.creational.designpatterns;

class AnimalSingleton {
	private static AnimalSingleton instance;

	private AnimalSingleton() {
	}

	public static AnimalSingleton getInstance() {
		if (instance == null) {
			instance = new AnimalSingleton();
		}
		return instance;
	}
}

public class SingletonPatternExample {
	public static void main(String[] args) {
		AnimalSingleton dogSingleton = AnimalSingleton.getInstance();
		AnimalSingleton anotherDogSingleton = AnimalSingleton.getInstance();
		System.out
				.println("Are both references pointing to the same instance? " + (dogSingleton == anotherDogSingleton));
	}
}
