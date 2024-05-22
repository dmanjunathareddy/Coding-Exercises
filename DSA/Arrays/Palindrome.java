package com.softgroup.dsa.array;
public class Palindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println("Is palindrome: " + isPalindrome(s)); // Output: true
    }
}
