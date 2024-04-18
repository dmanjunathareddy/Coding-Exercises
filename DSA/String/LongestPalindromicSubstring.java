package com.softgroup.dsa.string;

public class LongestPalindromicSubstring {
    // Function to find the longest palindromic substring in a given string
    public static String longestPalindrome(String s) {
        int n = s.length(); // Length of the string
        if (n == 0) {
            return ""; // If the string is empty, return an empty string
        }
        
        int start = 0; // Start index of the longest palindrome
        int maxLength = 1; // Length of the longest palindrome
        
        // Function to expand around the center
        for (int i = 0; i < n; i++) {
            // Check for odd-length palindromes
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);
            // Find the maximum length from the two checks
            int len = Math.max(len1, len2);
            
            // Update the start and maxLength if a longer palindrome is found
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        
        // Return the longest palindromic substring
        return s.substring(start, start + maxLength);
    }
    
    // Function to expand around the center and return the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        // Expand while the characters match and the pointers are within bounds
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }

    public static void main(String[] args) {
        // Test the function with some examples
        String s1 = "babad";
        System.out.println("Longest palindromic substring of \"" + s1 + "\": " + longestPalindrome(s1)); // Output: "bab" or "aba"
        
        String s2 = "cbbd";
        System.out.println("Longest palindromic substring of \"" + s2 + "\": " + longestPalindrome(s2)); // Output: "bb"
    }
}
