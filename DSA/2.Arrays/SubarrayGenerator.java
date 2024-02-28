package com.softgroup.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubarrayGenerator {
    public static List<List<Integer>> generateSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubarrays(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubarrays(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(current)); // Add a copy of the current subarray
            return;
        }
        generateSubarrays(arr, index + 1, current, result);
        current.add(arr[index]);
        generateSubarrays(arr, index + 1, current, result);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subarrays = generateSubarrays(arr);
        System.out.println("Subarrays:");
        for (List<Integer> subarray : subarrays) {
            System.out.println(subarray);
        }
    }
}
