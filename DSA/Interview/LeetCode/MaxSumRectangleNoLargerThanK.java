package com.softgroup.dsa.interview.leetcode;
import java.util.TreeSet;

public class MaxSumRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];

            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][right];
                }

                max = Math.max(max, maxSumSubarrayNoLargerThanK(rowSum, k));
            }
        }

        return max;
    }

    private int maxSumSubarrayNoLargerThanK(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> sumSet = new TreeSet<>();
        sumSet.add(0);

        for (int num : nums) {
            sum += num;
            Integer target = sumSet.ceiling(sum - k);
            if (target != null) {
                max = Math.max(max, sum - target);
            }
            sumSet.add(sum);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSumRectangleNoLargerThanK solver = new MaxSumRectangleNoLargerThanK();
        int[][] matrix = {
            {1, 0, 1},
            {0, -2, 3}
        };
        int k = 2;
        System.out.println(solver.maxSumSubmatrix(matrix, k)); // Output: 2
    }
}
