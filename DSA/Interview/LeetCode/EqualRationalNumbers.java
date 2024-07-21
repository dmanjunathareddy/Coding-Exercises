package com.softgroup.dsa.interview.leetcode;
public class EqualRationalNumbers {
    public static void main(String[] args) {
        String S = "0.(52)";
        String T = "0.5(25)";
        System.out.println(isRationalEqual(S, T));
    }

    public static boolean isRationalEqual(String S, String T) {
        return convertToDouble(S) == convertToDouble(T);
    }

    private static double convertToDouble(String s) {
        int indexOfOpenParen = s.indexOf('(');
        if (indexOfOpenParen == -1) {
            return Double.valueOf(s);
        }
        String nonRepeating = s.substring(0, indexOfOpenParen);
        String repeating = s.substring(indexOfOpenParen + 1, s.length() - 1);
        StringBuilder sb = new StringBuilder(nonRepeating);
        for (int i = 0; i < 20; i++) { // Append the repeating part 20 times to ensure precision
            sb.append(repeating);
        }
        return Double.valueOf(sb.toString());
    }
}
