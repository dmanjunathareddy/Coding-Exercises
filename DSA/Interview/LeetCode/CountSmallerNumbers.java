package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class CountSmallerNumbers {
    private class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
            result[i] = 0;
        }

        mergeSort(pairs, 0, n - 1, result);
        return Arrays.asList(result);
    }

    private void mergeSort(Pair[] pairs, int left, int right, Integer[] result) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSort(pairs, left, mid, result);
        mergeSort(pairs, mid + 1, right, result);
        merge(pairs, left, mid, right, result);
    }

    private void merge(Pair[] pairs, int left, int mid, int right, Integer[] result) {
        int n = right - left + 1;
        Pair[] sorted = new Pair[n];
        int i = left, j = mid + 1, k = 0, rightCount = 0;

        while (i <= mid && j <= right) {
            if (pairs[i].value <= pairs[j].value) {
                result[pairs[i].index] += rightCount;
                sorted[k++] = pairs[i++];
            } else {
                rightCount++;
                sorted[k++] = pairs[j++];
            }
        }

        while (i <= mid) {
            result[pairs[i].index] += rightCount;
            sorted[k++] = pairs[i++];
        }

        while (j <= right) {
            sorted[k++] = pairs[j++];
        }

        System.arraycopy(sorted, 0, pairs, left, n);
    }

    public static void main(String[] args) {
        CountSmallerNumbers solution = new CountSmallerNumbers();
        int[] nums = {5, 2, 6, 1};
        System.out.println(solution.countSmaller(nums)); // Output: [2, 1, 1, 0]
    }
}
