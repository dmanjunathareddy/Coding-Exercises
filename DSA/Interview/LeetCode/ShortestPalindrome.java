package com.softgroup.dsa.interview.leetcode;
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] p = new int[l.length()];

        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            if (l.charAt(i) == l.charAt(j)) {
                j++;
            }
            p[i] = j;
        }

        return rev.substring(0, s.length() - p[l.length() - 1]) + s;
    }

    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        String s = "aacecaaa";
        System.out.println(sp.shortestPalindrome(s));  // Output: "aaacecaaa"
        
        s = "abcd";
        System.out.println(sp.shortestPalindrome(s));  // Output: "dcbabcd"
    }
}
