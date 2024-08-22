package com.softgroup.dsa.interview;
import java.util.*;

public class MakeArrayStrictlyIncreasing {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(-1, 0);

        for (int value : arr1) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int key : dp.keySet()) {
                if (value > key) {
                    newDp.put(value, Math.min(newDp.getOrDefault(value, Integer.MAX_VALUE), dp.get(key)));
                }

                int idx = Arrays.binarySearch(arr2, key + 1);
                if (idx < 0) idx = -idx - 1;

                if (idx < arr2.length) {
                    newDp.put(arr2[idx], Math.min(newDp.getOrDefault(arr2[idx], Integer.MAX_VALUE), dp.get(key) + 1));
                }
            }
            dp = newDp;
        }

        int result = Integer.MAX_VALUE;
        for (int steps : dp.values()) {
            result = Math.min(result, steps);
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        MakeArrayStrictlyIncreasing solution = new MakeArrayStrictlyIncreasing();
        
        int[] arr1 = {1, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 2, 4};

        int result = solution.makeArrayIncreasing(arr1, arr2);
        System.out.println(result);  // Output: 1
    }
}
