package com.softgroup.dsa.arrays;

import java.util.Arrays;

public class MoveNegatives {

	public static void main(String[] args) {
		int[] array = { -3, 4, -1, 2, -7, 8, 6 };
		moveNegatives(array);
		System.out.println("Array with Negatives Moved to One Side: " + Arrays.toString(array));
	}

	public static void moveNegatives(int[] array) {
		int leftPointer = 0;
		int rightPointer = array.length - 1;
		while (leftPointer <= rightPointer) {
			while (leftPointer <= rightPointer && array[leftPointer] < 0) {
				leftPointer++;
			}
			while (leftPointer <= rightPointer && array[rightPointer] >= 0) {
				rightPointer--;
			}
			if (leftPointer <= rightPointer) {
				int temp = array[leftPointer];
				array[leftPointer] = array[rightPointer];
				array[rightPointer] = temp;
				leftPointer++;
				rightPointer--;
			}
		}
	}
}
