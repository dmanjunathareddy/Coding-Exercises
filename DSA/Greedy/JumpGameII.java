package com.softgroup.dsa.greedy;

public class JumpGameII {
	public static int jump(int[] nums) {
		int n = nums.length;
		if (n <= 1)
			return 0;

		int jumps = 0, farthest = 0, currentEnd = 0;

		for (int i = 0; i < n - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == currentEnd) {
				jumps++;
				currentEnd = farthest;
				if (currentEnd >= n - 1)
					break;
			}
		}

		return jumps;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("Minimum number of jumps required: " + jump(nums));
	}
}
