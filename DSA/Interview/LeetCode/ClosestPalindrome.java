package com.softgroup.dsa.interview.leetcode;
public class ClosestPalindrome {

    public static void main(String[] args) {
        int number = 123;
        int closestPalindrome = findClosestPalindrome(number);
        System.out.println("Closest palindrome to " + number + " is: " + closestPalindrome);
    }

    public static int findClosestPalindrome(int number) {
        if (isPalindrome(number)) {
            return number;
        }

        int lowerPalindrome = number - 1;
        int higherPalindrome = number + 1;

        while (true) {
            if (isPalindrome(lowerPalindrome)) {
                return lowerPalindrome;
            }

            if (isPalindrome(higherPalindrome)) {
                return higherPalindrome;
            }

            lowerPalindrome--;
            higherPalindrome++;
        }
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
