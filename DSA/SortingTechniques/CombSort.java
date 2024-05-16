package com.softgroup.dsa.sorting;
public class CombSort {

    // Method to sort the array using Comb Sort
    public static void combSort(int[] array) {
        int gap = array.length;
        boolean swapped = true;
        double shrinkFactor = 1.3;

        while (gap > 1 || swapped) {
            // Calculate the new gap value for the comb
            gap = (int) (gap / shrinkFactor);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;

            // Compare all elements with the current gap
            for (int i = 0; i + gap < array.length; i++) {
                if (array[i] > array[i + gap]) {
                    // Swap the elements
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    // Main method for testing the Comb Sort implementation
    public static void main(String[] args) {
        int[] array = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};

        System.out.println("Original array:");
        printArray(array);

        combSort(array);

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
