package com.softgroup.dsa.bitmanipulation;

public class XORWithoutOperator {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int xor = findXOR(a, b);
        System.out.println("XOR of " + a + " and " + b + " is: " + xor);
    }

    public static int findXOR(int a, int b) {
        int result = 0;
        int mask = 1;
        while (a > 0 || b > 0) {
            int bitA = a & 1; // Get the least significant bit of a
            int bitB = b & 1; // Get the least significant bit of b
            if (bitA != bitB) {
                // If the two bits are different, XOR result is 1
                result |= mask;
            }
            mask <<= 1; // Shift mask to check the next bit
            a >>= 1; // Shift a to the right to check the next bit
            b >>= 1; // Shift b to the right to check the next bit
        }
        return result;
    }
}
