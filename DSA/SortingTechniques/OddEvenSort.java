package com.softgroup.dsa.sorting;
public class OddEvenSort {

    // Method to perform the odd-even sort
    public static void oddEvenSort(int[] array) {
        boolean sorted = false; // Initially array is unsorted
        while (!sorted) {
            sorted = true;
            
            // Perform bubble sort on odd indexed elements
            for (int i = 1; i <= array.length - 2; i += 2) {
                if (array[i] > array[i + 1]) {
                    // Swap array[i] and array[i + 1]
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }

            // Perform bubble sort on even indexed elements
            for (int i = 0; i <= array.length - 2; i += 2) {
                if (array[i] > array[i + 1]) {
                    // Swap array[i] and array[i + 1]
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    // Main method to test the odd-even sort
    public static void main(String[] args) {
        int[] array = {34, 2, 10, -9, 7, 56, 22, 45, 1};

        System.out.println("Original Array:");
        for (int i : array) {
            System.out.print(i + " ");
        }

        oddEvenSort(array);

        System.out.println("\nSorted Array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
