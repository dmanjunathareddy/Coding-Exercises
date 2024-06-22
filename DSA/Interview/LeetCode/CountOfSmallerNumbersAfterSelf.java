package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
            result[i] = 0;
        }

        mergeSort(nums, indices, result, 0, n - 1);
        return Arrays.asList(result);
    }

    private void mergeSort(int[] nums, int[] indices, Integer[] result, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, result, left, mid);
        mergeSort(nums, indices, result, mid + 1, right);
        merge(nums, indices, result, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, Integer[] result, int left, int mid, int right) {
        int[] tempIndices = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                tempIndices[k++] = indices[j++];
                rightCount++;
            } else {
                tempIndices[k] = indices[i];
                result[indices[i]] += rightCount;
                k++;
                i++;
            }
        }

        while (i <= mid) {
            tempIndices[k] = indices[i];
            result[indices[i]] += rightCount;
            k++;
            i++;
        }

        while (j <= right) {
            tempIndices[k++] = indices[j++];
        }

        System.arraycopy(tempIndices, 0, indices, left, right - left + 1);
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = solution.countSmaller(nums);
        System.out.println("Count of smaller numbers after self: " + result);
    }
}
