package com.softgroup.dsa.recursion;

public class HeadRecursionExample {
    public static void printNumbers(int n) {
        if (n > 0) {
            printNumbers(n - 1); // Head recursion: recursive call is made before printing
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Printing numbers from 1 to " + n + ":");
        printNumbers(n);
    }
}
