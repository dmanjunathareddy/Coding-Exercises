package com.softgroup.dsa.interview.leetcode;

import java.util.Arrays;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        
        dp[0][0][0] = grid[0][0]; // Starting point

        for (int t = 1; t <= 2 * (n - 1); t++) {
            for (int x1 = Math.max(0, t - (n - 1)); x1 <= Math.min(n - 1, t); x1++) {
                for (int x2 = Math.max(0, t - (n - 1)); x2 <= Math.min(n - 1, t); x2++) {
                    int y1 = t - x1;
                    int y2 = t - x2;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) continue;
                    
                    int cherries = grid[x1][y1];
                    if (x1 != x2) cherries += grid[x2][y2];
                    
                    int best = dp[x1][x2][t - 1];
                    if (x1 > 0) best = Math.max(best, dp[x1 - 1][x2][t - 1]);
                    if (x2 > 0) best = Math.max(best, dp[x1][x2 - 1][t - 1]);
                    if (x1 > 0 && x2 > 0) best = Math.max(best, dp[x1 - 1][x2 - 1][t - 1]);
                    
                    dp[x1][x2][t] = best + cherries;
                }
            }
        }
        
        return Math.max(0, dp[n - 1][n - 1][2 * (n - 1)]);
    }

    public static void main(String[] args) {
        CherryPickup solution = new CherryPickup();
        int[][] grid = {
            {0, 1, -1},
            {1, 0, -1},
            {1, 1,  1}
        };
        System.out.println(solution.cherryPickup(grid)); // Output: 5
    }
}
