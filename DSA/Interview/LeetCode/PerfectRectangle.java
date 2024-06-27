package com.softgroup.dsa.interview.leetcode;
import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }

        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        Set<String> points = new HashSet<>();
        int area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String[] corners = {
                rect[0] + " " + rect[1],
                rect[0] + " " + rect[3],
                rect[2] + " " + rect[1],
                rect[2] + " " + rect[3]
            };

            for (String corner : corners) {
                if (!points.add(corner)) {
                    points.remove(corner);
                }
            }
        }

        if (!points.contains(x1 + " " + y1) || !points.contains(x1 + " " + y2) || 
            !points.contains(x2 + " " + y1) || !points.contains(x2 + " " + y2) || 
            points.size() != 4) {
            return false;
        }

        return area == (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        PerfectRectangle pr = new PerfectRectangle();
        int[][] rectangles = {
            {1, 1, 3, 3},
            {3, 1, 4, 2},
            {3, 2, 4, 4},
            {1, 3, 2, 4},
            {2, 3, 3, 4}
        };
        System.out.println(pr.isRectangleCover(rectangles)); // Output: true
    }
}
