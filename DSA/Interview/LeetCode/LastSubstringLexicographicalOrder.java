package com.softgroup.dsa.interview.leetcode.top150;
public class LastSubstringLexicographicalOrder {
    public static void main(String[] args) {
        String input = "abab";
        System.out.println("The last substring in lexicographical order is: " + lastSubstring(input));
    }

    public static String lastSubstring(String s) {
        int n = s.length();
        String lastSubstring = "";
        
        for (int i = 0; i < n; i++) {
            String currentSubstring = s.substring(i);
            if (currentSubstring.compareTo(lastSubstring) > 0) {
                lastSubstring = currentSubstring;
            }
        }
        
        return lastSubstring;
    }
}
