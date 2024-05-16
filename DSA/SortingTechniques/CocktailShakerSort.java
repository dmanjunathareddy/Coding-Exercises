package com.softgroup.dsa.sorting;
public class CocktailShakerSort {

    // Method to sort the array using Cocktail Shaker Sort
    public static void cocktailShakerSort(int[] array) {
        boolean swapped = true;
        int start = 0;
        int end = array.length - 1;

        while (swapped) {
            // Reset the swapped flag on entering the loop
            swapped = false;

            // Bubble sort in the forward direction
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    // Swap the elements
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }

            // Otherwise, reset the swapped flag so we can check in the next stage
            swapped = false;

            // Move the end point back by one because the item at the end is in its correct position
            end--;

            // Bubble sort in the backward direction
            for (int i = end - 1; i >= start; i--) {
                if (array[i] > array[i + 1]) {
                    // Swap the elements
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // Increase the starting point because the item at the start is in its correct position
            start++;
        }
    }

    // Main method for testing the Cocktail Shaker Sort implementation
    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2, 8, 0, 2};

        System.out.println("Original array:");
        printArray(array);

        cocktailShakerSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    // Helper method to print the array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
