package com.softgroup.creational.designpatterns;

//Prototype interface
interface AnimalPrototype extends Cloneable {
	AnimalPrototype clone();
}

//Concrete Prototype
class DogPrototype implements AnimalPrototype {
	private String species = "Dog";
	private String sound = "Woof!";
	private String color = "Brown";

	@Override
	public AnimalPrototype clone() {
		return new DogPrototype();
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void display() {
		System.out.println("Species: " + species);
		System.out.println("Sound: " + sound);
		System.out.println("Color: " + color);
	}
}

//Client
public class PrototypePatternExample {
	public static void main(String[] args) {
		// Create a prototype instance
		AnimalPrototype dogPrototype = new DogPrototype();

		// Clone the prototype to create a new instance
		AnimalPrototype clonedDog = dogPrototype.clone();

		// Customize the cloned object
		((DogPrototype) clonedDog).setSound("Modified Woof!");
		((DogPrototype) clonedDog).setColor("Modified Brown");

		// Display original and cloned objects
		System.out.println("Original Dog Prototype:");
		((DogPrototype) dogPrototype).display();

		System.out.println("\nCloned Dog:");
		((DogPrototype) clonedDog).display();
	}
}
