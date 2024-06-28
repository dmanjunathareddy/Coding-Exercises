package com.softgroup.dsa.interview.leetcode;
public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
        }

        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        if (n < 6) {
            return Math.max(missingTypes, 6 - n);
        }

        int replace = 0, oneSeq = 0, twoSeq = 0;
        for (int i = 2; i < n; ++i) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                int length = 2;
                while (i < n && s.charAt(i) == s.charAt(i - 1)) {
                    length++;
                    i++;
                }
                replace += length / 3;
                if (length % 3 == 0) oneSeq++;
                else if (length % 3 == 1) twoSeq++;
            }
        }

        if (n <= 20) {
            return Math.max(missingTypes, replace);
        }

        int delete = n - 20;

        replace -= Math.min(delete, oneSeq * 1) / 1;
        replace -= Math.min(Math.max(delete - oneSeq, 0), twoSeq * 2) / 2;
        replace -= Math.max(delete - oneSeq - 2 * twoSeq, 0) / 3;

        return delete + Math.max(missingTypes, replace);
    }

    public static void main(String[] args) {
        StrongPasswordChecker checker = new StrongPasswordChecker();
        String password = "aA1";
        System.out.println(checker.strongPasswordChecker(password)); // Output: 3
    }
}
