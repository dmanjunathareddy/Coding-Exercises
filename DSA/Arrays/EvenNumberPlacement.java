package com.softgroup.dsa.array;
public class EvenNumberPlacement {

    // Method to check if all even numbers can be placed at even indices
    public static String canAccommodateEvenNumbers(int[] arr) {
        int evenCount = 0;
        int n = arr.length;

        // Count the number of even numbers in the array
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // Calculate the maximum number of even indices
        int maxEvenIndices = (n + 1) / 2;

        // Check if even numbers can fit in the even indices
        if (evenCount <= maxEvenIndices) {
            return "Yes";
        } else {
            return "No";
        }
    }

    // Main method to test the canAccommodateEvenNumbers method
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};  // Example array 1
        int[] arr2 = {2, 4, 6, 8, 10, 12};  // Example array 2
        int[] arr3 = {1, 3, 5, 7, 9};  // Example array 3
        int[] arr4 = {2, 4, 1, 6};  // Example array 4

        System.out.println(canAccommodateEvenNumbers(arr1));  // Output: Yes
        System.out.println(canAccommodateEvenNumbers(arr2));  // Output: No
        System.out.println(canAccommodateEvenNumbers(arr3));  // Output: Yes
        System.out.println(canAccommodateEvenNumbers(arr4));  // Output: Yes
    }
}
