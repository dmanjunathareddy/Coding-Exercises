package com.softgroup.dsa.interview.leetcode;
public class RemoveBoxes {

    public static void main(String[] args) {
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println("Maximum points: " + removeBoxes(boxes));
    }

    public static int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return calculatePoints(dp, boxes, 0, n - 1, 0);
    }

    private static int calculatePoints(int[][][] dp, int[] boxes, int l, int r, int k) {
        if (l > r) return 0;
        if (dp[l][r][k] != 0) return dp[l][r][k];

        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        dp[l][r][k] = calculatePoints(dp, boxes, l, r - 1, 0) + (k + 1) * (k + 1);

        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(dp, boxes, l, i, k + 1) + calculatePoints(dp, boxes, i + 1, r - 1, 0));
            }
        }

        return dp[l][r][k];
    }
}
