package com.softgroup.dsa.interview.leetcode;
public class MaxSumOfThreeSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[3];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = k, total = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > total) {
                left[i] = i + 1 - k;
                total = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }

        right[n - k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= total) {
                right[i] = i;
                total = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            if (result[0] == -1 || (sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r] >
                    sum[result[0] + k] - sum[result[0]] + sum[result[1] + k] - sum[result[1]] + sum[result[2] + k] - sum[result[2]])) {
                result[0] = l;
                result[1] = i;
                result[2] = r;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSumOfThreeSubarrays solver = new MaxSumOfThreeSubarrays();
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] result = solver.maxSumOfThreeSubarrays(nums, k);
        for (int idx : result) {
            System.out.print(idx + " ");
        }
    }
}
