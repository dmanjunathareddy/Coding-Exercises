package com.softgroup.dsa.interview.leetcode;
public class LargestPalindromeProduct {
    
    public static void main(String[] args) {
        int n = 3; // Change this to the number of digits
        System.out.println("Largest palindrome product of two " + n + "-digit numbers is: " + findLargestPalindrome(n));
    }

    public static int findLargestPalindrome(int n) {
        int upperLimit = (int) Math.pow(10, n) - 1;
        int lowerLimit = (int) Math.pow(10, n - 1);
        int maxPalindrome = 0;

        for (int i = upperLimit; i >= lowerLimit; i--) {
            for (int j = i; j >= lowerLimit; j--) {
                int product = i * j;
                if (isPalindrome(product) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }

        return maxPalindrome;
    }

    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
