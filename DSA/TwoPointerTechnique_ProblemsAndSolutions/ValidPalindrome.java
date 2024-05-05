package com.softgroup.dsa.greedy.twopointer;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            char lChar = Character.toLowerCase(s.charAt(left));
            char rChar = Character.toLowerCase(s.charAt(right));
            
            if (!Character.isLetterOrDigit(lChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rChar)) {
                right--;
            } else if (lChar != rChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome: " + isPalindrome(s)); // Output: true
    }
}
