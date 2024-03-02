package com.softgroup.dsa.recursion;

public class TailRecursionExample {
    public static int factorial(int n) {
        return factorialHelper(n, 1);
    }

    private static int factorialHelper(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        }
        return factorialHelper(n - 1, n * accumulator); // Tail recursive call
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }
}
