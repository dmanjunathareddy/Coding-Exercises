package com.softgroup.dsa.sliding;

import java.util.HashMap;
import java.util.Map;

public class MinOperationsToReduceXToZero {
    public static int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        
        if (target == 0)
            return nums.length;
        
        int maxLength = -1;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Adding this to handle the case when the entire array is the answer
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                maxLength = Math.max(maxLength, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        
        return maxLength != -1 ? nums.length - maxLength : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        System.out.println("Minimum operations to reduce X to zero: " + minOperations(nums, x));
    }
}
