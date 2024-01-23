package com.softgroup.creational.designpatterns;

//Product
class Animal {
	private String species;
	private String sound;
	private String color;

	public Animal(String species, String sound, String color) {
		this.species = species;
		this.sound = sound;
		this.color = color;
	}

	public void makeSound() {
		System.out.println(sound);
	}

	public void display() {
		System.out.println("Species: " + species);
		System.out.println("Sound: " + sound);
		System.out.println("Color: " + color);
	}
}

//Builder interface
interface AnimalBuilder {
	AnimalBuilder setSpecies(String species);

	AnimalBuilder setSound(String sound);

	AnimalBuilder setColor(String color);

	Animal build();
}

//Concrete Builder
class AnimalBuilderImpl implements AnimalBuilder {
	private String species;
	private String sound;
	private String color;

	@Override
	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}

	@Override
	public AnimalBuilder setSound(String sound) {
		this.sound = sound;
		return this;
	}

	@Override
	public AnimalBuilder setColor(String color) {
		this.color = color;
		return this;
	}

	@Override
	public Animal build() {
		return new Animal(species, sound, color);
	}
}

//Director
class AnimalDirector {
	private AnimalBuilder animalBuilder;

	public AnimalDirector(AnimalBuilder animalBuilder) {
		this.animalBuilder = animalBuilder;
	}

	public Animal construct() {
		return animalBuilder.build();
	}
}

public class BuilderPatternExample {
	public static void main(String[] args) {
		AnimalBuilder animalBuilder = new AnimalBuilderImpl();

		AnimalDirector animalDirector = new AnimalDirector(animalBuilder);
		Animal dog = animalDirector.construct().setSpecies("Dog").setSound("Woof!").setColor("Brown").build();

		Animal cat = animalDirector.construct().setSpecies("Cat").setSound("Meow!").setColor("Black").build();

		dog.display();
		System.out.println();
		cat.display();
	}
}
