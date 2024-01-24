package com.softgroup.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 7, 6, 9, 1, 2, };
		System.out.println("Original Array:");
		printArray(arr);
		mergeSort(arr);
		System.out.println("Sorted Array:");
		printArray(arr);

	}

	public static void mergeSort(int[] array) {
		int length = array.length;

		if (length > 1) {
			int mid = length / 2;
			int[] leftArray = Arrays.copyOfRange(array, 0, mid);
			int[] rightArray = Arrays.copyOfRange(array, mid, length);
			mergeSort(leftArray);
			mergeSort(rightArray);
			merge(array, leftArray, rightArray);
		}
	}

	public static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int leftLength = leftArray.length;
		int rightLength = rightArray.length;

		int i = 0, j = 0, k = 0;
		while (i < leftLength && j < rightLength) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while (i < leftLength) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightLength) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void printArray(int[] arr) {
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}
