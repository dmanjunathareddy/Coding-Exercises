package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class SetIntersectionSizeAtLeastTwo {
    public static int intersectionSizeAtLeastTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int last = -1, secondLast = -1, count = 0;
        
        for (int[] interval : intervals) {
            if (interval[0] > last) {
                count += 2;
                secondLast = interval[1] - 1;
                last = interval[1];
            } else if (interval[0] > secondLast) {
                count += 1;
                secondLast = last;
                last = interval[1];
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 3}, {1, 4}, {2, 5}, {3, 5} };
        System.out.println(intersectionSizeAtLeastTwo(intervals)); // Output: 3
    }
}
