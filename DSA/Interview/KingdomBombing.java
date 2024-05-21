package com.softgroup.dsa.interview;
import java.util.Arrays;
import java.util.Comparator;

public class KingdomBombing {
    public static int minBombs(int[][] intervals) {
        // If there are no intervals, no bombs are needed
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on their end points
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int bombs = 0;
        int lastBombPosition = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            // If the current interval is not covered by the last bomb
            if (interval[0] > lastBombPosition) {
                // Place a bomb at the end of the current interval
                lastBombPosition = interval[1];
                bombs++;
            }
        }

        return bombs;
    }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 4},
            {2, 3},
            {3, 5},
            {7, 9},
            {6, 8}
        };
        System.out.println("Minimum number of bombs needed: " + minBombs(intervals));
    }
}
