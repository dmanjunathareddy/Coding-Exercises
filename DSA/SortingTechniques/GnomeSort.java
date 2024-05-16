package com.softgroup.dsa.sorting;
public class GnomeSort {

    // Method to sort the array using Gnome Sort
    public static void gnomeSort(int[] array) {
        int index = 0;

        while (index < array.length) {
            if (index == 0 || array[index] >= array[index - 1]) {
                index++;
            } else {
                // Swap the elements
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }

    // Main method for testing the Gnome Sort implementation
    public static void main(String[] args) {
        int[] array = {34, 2, 10, -9, 7, 8, -1};

        System.out.println("Original array:");
        printArray(array);

        gnomeSort(array);

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
