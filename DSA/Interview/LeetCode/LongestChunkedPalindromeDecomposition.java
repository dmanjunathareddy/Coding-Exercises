package com.softgroup.dsa.interview.leetcode.top150;
public class LongestChunkedPalindromeDecomposition {
    public static void main(String[] args) {
        String input = "ghiabcdefhelloadamhelloabcdefghi";
        System.out.println("Longest chunked palindrome decomposition: " + longestDecomposition(input));
    }

    public static int longestDecomposition(String text) {
        return decompose(text, 0, text.length() - 1);
    }

    private static int decompose(String text, int left, int right) {
        if (left > right) {
            return 0;
        }
        
        for (int len = 1; left + len - 1 < right - len + 1; len++) {
            if (text.substring(left, left + len).equals(text.substring(right - len + 1, right + 1))) {
                return 2 + decompose(text, left + len, right - len);
            }
        }
        
        return 1;
    }
}
