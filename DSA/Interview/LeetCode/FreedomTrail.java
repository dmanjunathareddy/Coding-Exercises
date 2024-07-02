package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class FreedomTrail {

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println("Minimum steps: " + findRotateSteps(ring, key));
    }

    public static int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        Map<Character, List<Integer>> charToIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new ArrayList<>());
            }
            charToIndex.get(c).add(i);
        }

        int[][] dp = new int[m + 1][n];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            char c = key.charAt(i - 1);
            for (int j : charToIndex.get(c)) {
                for (int k = 0; k < n; k++) {
                    if (dp[i - 1][k] != Integer.MAX_VALUE) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + step + 1);
                    }
                }
            }
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSteps = Math.min(minSteps, dp[m][i]);
        }

        return minSteps;
    }
}
