package com.softgroup.dsa.arrays;

public class MaxMinArray {

	public static void main(String[] args) {
		int[] array = { 4, 3, 7, 6, 9, 1, 2, 5 };
		int maxElement = findMax(array);
		int minElement = findMin(array);

		System.out.println("Maximum Element: " + maxElement);
		System.out.println("Minimum Element: " + minElement);
	}

	public static int findMax(int[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}

		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static int findMin(int[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}

		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
