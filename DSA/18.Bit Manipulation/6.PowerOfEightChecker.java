package com.softgroup.dsa.bitmanipulation;

public class PowerOfEightChecker {
    public static boolean isPowerOfEight(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        int number = 64; // Example number

        if (isPowerOfEight(number)) {
            System.out.println(number + " is a power of 8.");
        } else {
            System.out.println(number + " is not a power of 8.");
        }
    }
}
