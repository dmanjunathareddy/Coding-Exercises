package com.softgroup.dsa.array;

public class MinimumJumps {

	public static int minJumps(int[] arr) {
		int n = arr.length;
		if (n <= 1) {
			return 0;
		}

		int[] jumps = new int[n];
		jumps[0] = 0;

		for (int i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}

		return jumps[n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };
		System.out.println("Minimum number of jumps: " + minJumps(arr));
	}
}
