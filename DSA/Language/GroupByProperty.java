package com.softgroup.language.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class GroupByProperty {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("John", 30), new Person("Sarah", 25), new Person("Tom", 30),
				new Person("David", 25));

		// Group people by age
		Map<Integer, List<Person>> peopleByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));

		// Print the groups
		peopleByAge.forEach((age, group) -> {
			System.out.println("Age: " + age);
			group.forEach(person -> System.out.println("  " + person.getName()));
		});
	}
}
