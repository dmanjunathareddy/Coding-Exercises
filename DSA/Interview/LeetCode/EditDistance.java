package com.softgroup.dsa.interview.leetcode;
public class EditDistance {
    // Method to find the minimum of three numbers
    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    // Method to calculate the edit distance between two strings
    public static int calculateEditDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // Create a 2D array to store the distances
        int[][] dp = new int[len1 + 1][len2 + 1];

        // Initialize the first row and column of the array
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array using the recurrence relation
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j],     // Deletion
                                       dp[i][j - 1],     // Insertion
                                       dp[i - 1][j - 1]);// Substitution
                }
            }
        }

        return dp[len1][len2];
    }

    // Main method for testing
    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";
        
        System.out.println("Edit Distance between " + str1 + " and " + str2 + " is " + calculateEditDistance(str1, str2));
    }
}
