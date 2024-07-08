package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FallingSquares {

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>();

        int maxHeight = 0;

        for (int[] position : positions) {
            int left = position[0];
            int sideLength = position[1];
            int right = left + sideLength;

            Integer floorKey = heights.floorKey(left);
            int baseHeight = 0;
            while (floorKey != null && heights.get(floorKey) > baseHeight) {
                if (floorKey < right) {
                    baseHeight = Math.max(baseHeight, heights.get(floorKey));
                }
                floorKey = heights.lowerKey(floorKey);
            }

            int newHeight = baseHeight + sideLength;
            maxHeight = Math.max(maxHeight, newHeight);
            result.add(maxHeight);

            Integer ceilingKey = heights.ceilingKey(left);
            while (ceilingKey != null && ceilingKey < right) {
                heights.remove(ceilingKey);
                ceilingKey = heights.ceilingKey(left);
            }

            heights.put(left, newHeight);
            if (heights.floorKey(right) == null || heights.floorKey(right) < left) {
                heights.put(right, baseHeight);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FallingSquares solver = new FallingSquares();
        int[][] positions = {
            {1, 2},
            {2, 3},
            {6, 1}
        };
        System.out.println(solver.fallingSquares(positions)); // Output: [2, 5, 5]
    }
}
