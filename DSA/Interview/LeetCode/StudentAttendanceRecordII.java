package com.softgroup.dsa.interview;
public class StudentAttendanceRecordII {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        // dp[i][A][L] will be the number of valid sequences of length i, with A 'A's and L consecutive 'L's
        int[][][] dp = new int[n + 1][2][3];

        // Base case: there's one valid sequence of length 0 (the empty sequence)
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int a = 0; a <= 1; a++) {
                for (int l = 0; l <= 2; l++) {
                    // Adding 'P'
                    dp[i][a][0] = (dp[i][a][0] + dp[i - 1][a][l]) % MOD;
                    
                    // Adding 'A'
                    if (a > 0) {
                        dp[i][a][0] = (dp[i][a][0] + dp[i - 1][a - 1][l]) % MOD;
                    }

                    // Adding 'L'
                    if (l > 0) {
                        dp[i][a][l] = (dp[i][a][l] + dp[i - 1][a][l - 1]) % MOD;
                    }
                }
            }
        }

        // Sum all valid sequences of length n
        int result = 0;
        for (int a = 0; a <= 1; a++) {
            for (int l = 0; l <= 2; l++) {
                result = (result + dp[n][a][l]) % MOD;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII solution = new StudentAttendanceRecordII();
        int n1 = 2;
        System.out.println(solution.checkRecord(n1)); // Output: 8

        int n2 = 10101;
        System.out.println(solution.checkRecord(n2)); // Output: a large number modulo 10^9 + 7
    }
}
