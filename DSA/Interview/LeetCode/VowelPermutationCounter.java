package com.softgroup.dsa.interview.leetcode;
public class VowelPermutationCounter {
    public static int countVowelPermutation(int n) {
        // Define the modulo constant
        int MOD = 1_000_000_007;

        // Initialize dp array for n = 1
        long[] dp = new long[5];
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }

        // Temporary array to hold counts for the next length
        long[] newDp = new long[5];

        // Iterate over lengths from 2 to n
        for (int length = 2; length <= n; length++) {
            // Update newDp based on current dp values
            newDp[0] = (dp[1] + dp[2] + dp[4]) % MOD; // 'a' can follow 'e', 'i', 'u'
            newDp[1] = (dp[0] + dp[2]) % MOD;         // 'e' can follow 'a', 'i'
            newDp[2] = (dp[1] + dp[3]) % MOD;         // 'i' can follow 'e', 'o'
            newDp[3] = dp[2] % MOD;                   // 'o' can follow 'i'
            newDp[4] = (dp[2] + dp[3]) % MOD;         // 'u' can follow 'i', 'o'

            // Copy newDp to dp for the next iteration
            System.arraycopy(newDp, 0, dp, 0, 5);
        }

        // Sum up all counts for the final length n
        long result = 0;
        for (int i = 0; i < 5; i++) {
            result = (result + dp[i]) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int n = 5; // Example: length of the string
        int result = countVowelPermutation(n);
        System.out.println("Number of vowel permutations of length " + n + " is: " + result);
    }
}
