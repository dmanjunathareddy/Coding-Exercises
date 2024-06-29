package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesSubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int difference = (int) diff;
                int count = dp[j].getOrDefault(difference, 0);
                result += count;
                dp[i].put(difference, dp[i].getOrDefault(difference, 0) + count + 1);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        ArithmeticSlicesSubsequence solution = new ArithmeticSlicesSubsequence();
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println("The number of arithmetic subsequences is: " + solution.numberOfArithmeticSlices(nums));
    }
}
