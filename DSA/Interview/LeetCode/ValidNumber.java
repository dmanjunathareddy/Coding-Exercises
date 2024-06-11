package com.softgroup.dsa.interview.leetcode;
public class ValidNumber {

    public static boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;
        
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;  // Initially true for cases without 'e'
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                numberSeen = true;
                numberAfterE = true; // Valid digit after 'e' or 'E'
            } else if (c == '.') {
                if (pointSeen || eSeen) return false;
                pointSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numberSeen) return false;
                eSeen = true;
                numberAfterE = false; // Reset for checking digits after 'e'
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }

    public static void main(String[] args) {
        String[] testCases = {"0", " 0.1 ", "abc", "1 a", "2e10", " -90e3   ", " 1e", "e3", " 6e-1", " 99e2.5 ", "53.5e93", " --6 ", "-+3", "95a54e53"};

        for (String testCase : testCases) {
            System.out.println("\"" + testCase + "\" is " + (isNumber(testCase) ? "a valid number." : "not a valid number."));
        }
    }
}
