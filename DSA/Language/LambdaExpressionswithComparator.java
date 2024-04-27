package com.softgroup.language.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionswithComparator {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Sarah", "Tom", "David");

		// Sort names alphabetically using lambda expression
		Collections.sort(names, (name1, name2) -> name1.compareTo(name2));
		System.out.println("Sorted names: " + names);
	}
}
