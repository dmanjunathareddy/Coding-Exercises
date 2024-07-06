package com.softgroup.dsa.interview.leetcode;
public class DecodeWaysII {
    public int numDecodings(String s) {
        long MOD = 1000000007;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : (s.charAt(0) == '*' ? 9 : 1);

        for (int i = 2; i <= s.length(); i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            // For single digit
            if (second == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (second >= '1' && second <= '9') {
                dp[i] += dp[i - 1];
            }

            // For two digits
            if (first == '*') {
                if (second == '*') {
                    dp[i] += 15 * dp[i - 2]; // 11-19 and 21-26
                } else if (second >= '0' && second <= '6') {
                    dp[i] += 2 * dp[i - 2]; // 16 and 26
                } else {
                    dp[i] += dp[i - 2]; // 17-19
                }
            } else if (first == '1') {
                if (second == '*') {
                    dp[i] += 9 * dp[i - 2]; // 11-19
                } else {
                    dp[i] += dp[i - 2]; // 10-19
                }
            } else if (first == '2') {
                if (second == '*') {
                    dp[i] += 6 * dp[i - 2]; // 21-26
                } else if (second >= '0' && second <= '6') {
                    dp[i] += dp[i - 2]; // 20-26
                }
            }

            dp[i] %= MOD;
        }

        return (int) dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWaysII decoder = new DecodeWaysII();
        System.out.println(decoder.numDecodings("*")); // Example test case
        System.out.println(decoder.numDecodings("1*"));
        System.out.println(decoder.numDecodings("2*"));
    }
}
