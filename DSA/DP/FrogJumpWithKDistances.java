package com.softgroup.dsa.dp;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJumpWithKDistances {

    public static boolean canCross(int[] stones, int k) {
        int n = stones.length;

        // Create a hashmap to store the index of each stone for quick access
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }

        // Base case, the frog can only jump one unit from the first stone
        map.get(stones[0]).add(1);

        for (int i = 0; i < n - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                for (int j = step - k; j <= step + k; j++) { // Consider jumps up to k distances
                    if (j <= 0) continue; // Skip non-positive or zero jumps
                    int reach = j + stone;
                    if (reach == stones[n - 1]) return true;
                    HashSet<Integer> set = map.get(reach);
                    if (set != null) {
                        set.add(j);
                    }
                }
            }
        }

        // No way to reach the last stone
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17}; // Example stones
        int k = 3; // Example k distance
        System.out.println("Can the frog cross the river with k distances? " + canCross(stones, k));
    }
}
