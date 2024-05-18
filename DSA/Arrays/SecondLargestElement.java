package com.softgroup.dsa.array;
public class SecondLargestElement {

    // Method to find the second largest element in an array
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        // Initialize the largest and second largest elements
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse the array to find the first and second largest elements
        for (int num : arr) {
            if (num > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                secondLargest = num;
            }
        }

        // Check if second largest is still Integer.MIN_VALUE
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found");
        }

        return secondLargest;
    }

    // Main method to test the findSecondLargest method
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 8, 9};
        
        try {
            int secondLargest = findSecondLargest(arr);
            System.out.println("The second largest element is: " + secondLargest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
