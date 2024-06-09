package com.softgroup.dsa.array;

public class Factorial {

    // Method to calculate the factorial of a non-negative integer n
    public static long factorial(int n) {
        // Check if the input is a non-negative integer
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }

        // Initialize result as 1 (factorial of 0 and 1 is 1)
        long result = 1;

        // Calculate factorial using iteration
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // Main method to test the factorial function
    public static void main(String[] args) {
        // Example input
        int n = 5;

        // Calculate and print the factorial of the input number
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }
}
