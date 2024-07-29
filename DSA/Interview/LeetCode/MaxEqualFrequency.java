package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.Map;

public class MaxEqualFrequency {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 5, 3, 3, 5};
        System.out.println(maxEqualFreq(nums));
    }

    public static int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int currCount = count.getOrDefault(num, 0);
            if (currCount > 0) {
                freq.put(currCount, freq.get(currCount) - 1);
            }

            currCount++;
            count.put(num, currCount);
            freq.put(currCount, freq.getOrDefault(currCount, 0) + 1);
            maxFreq = Math.max(maxFreq, currCount);

            boolean condition1 = maxFreq == 1;
            boolean condition2 = freq.get(maxFreq) * maxFreq == i + 1;
            boolean condition3 = (freq.get(maxFreq) * maxFreq + freq.getOrDefault(maxFreq - 1, 0) * (maxFreq - 1) == i + 1) && (freq.get(maxFreq) == 1);

            if (condition1 || condition2 || condition3) {
                res = i + 1;
            }
        }

        return res;
    }
}
