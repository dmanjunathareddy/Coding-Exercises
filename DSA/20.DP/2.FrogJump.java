package com.softgroup.dsa.dp;

import java.util.*;

public class FrogJump {

	public static boolean canCross(int[] stones) {
		int n = stones.length;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(stones[i], new HashSet<>());
		}
		map.get(stones[0]).add(1);

		for (int i = 0; i < n - 1; i++) {
			int stone = stones[i];
			for (int step : map.get(stone)) {
				int reach = step + stone;
				if (reach == stones[n - 1])
					return true;
				HashSet<Integer> set = map.get(reach);
				if (set != null) {
					if (step - 1 > 0)
						set.add(step - 1);
					set.add(step);
					set.add(step + 1);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 }; // Example stones
		System.out.println("Can the frog cross the river? " + canCross(stones));
	}
}
