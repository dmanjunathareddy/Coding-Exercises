package com.softgroup.creational.designpatterns;

//Product interface
interface Animal {
 void sound();
}

//Concrete Product 1
class Dog implements Animal {
 @Override
 public void sound() {
     System.out.println("Woof!");
 }
}

//Concrete Product 2
class Cat implements Animal {
 @Override
 public void sound() {
     System.out.println("Meow!");
 }
}

//Creator interface
interface AnimalFactory {
 Animal createAnimal();
}

//Concrete Creator 1
class DogFactory implements AnimalFactory {
 @Override
 public Animal createAnimal() {
     return new Dog();
 }
}

//Concrete Creator 2
class CatFactory implements AnimalFactory {
 @Override
 public Animal createAnimal() {
     return new Cat();
 }
}

public class FactoryMethodExample {
 public static void main(String[] args) {
     AnimalFactory dogFactory = new DogFactory();
     Animal dog = dogFactory.createAnimal();
     dog.sound();

     AnimalFactory catFactory = new CatFactory();
     Animal cat = catFactory.createAnimal();
     cat.sound();
 }
}

