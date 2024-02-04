package com.softgroup.creational.designpatterns;

//Abstract Product A
interface Animal {
	void sound();
}

//Concrete Product A1
class Dog implements Animal {
	@Override
	public void sound() {
		System.out.println("Woof!");
	}
}

//Concrete Product A2
class Cat implements Animal {
	@Override
	public void sound() {
		System.out.println("Meow!");
	}
}

//Abstract Product B
interface Color {
	void fill();
}

//Concrete Product B1
class Brown implements Color {
	@Override
	public void fill() {
		System.out.println("Filling with brown color");
	}
}

//Concrete Product B2
class Black implements Color {
	@Override
	public void fill() {
		System.out.println("Filling with black color");
	}
}

//Abstract Factory
interface AbstractFactory {
	Animal createAnimal();

	Color createColor();
}

//Concrete Factory 1
class DogFactory implements AbstractFactory {
	@Override
	public Animal createAnimal() {
		return new Dog();
	}

	@Override
	public Color createColor() {
		return new Brown();
	}
}

//Concrete Factory 2
class CatFactory implements AbstractFactory {
	@Override
	public Animal createAnimal() {
		return new Cat();
	}

	@Override
	public Color createColor() {
		return new Black();
	}
}

public class AbstractFactoryExample {
	public static void main(String[] args) {
		AbstractFactory dogFactory = new DogFactory();
		Animal dog = dogFactory.createAnimal();
		Color brown = dogFactory.createColor();

		dog.sound();
		brown.fill();

		AbstractFactory catFactory = new CatFactory();
		Animal cat = catFactory.createAnimal();
		Color black = catFactory.createColor();

		cat.sound();
		black.fill();
	}
}
