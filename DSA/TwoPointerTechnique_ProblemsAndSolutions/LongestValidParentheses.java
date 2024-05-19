package com.softgroup.dsa.greedy.twopointer;
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int maxLength = 0;
        int left = 0, right = 0;

        // Left to right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        // Right to left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "(()))())(";
        int result = longestValidParentheses(s);
        System.out.println("Longest valid parentheses length: " + result);
    }
}
