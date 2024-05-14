package com.softgroup.dsa.interview;
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int reversed = 0, original = x;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        int num = 121;
        System.out.println("Is " + num + " a palindrome? " + isPalindrome(num));
    }
}
