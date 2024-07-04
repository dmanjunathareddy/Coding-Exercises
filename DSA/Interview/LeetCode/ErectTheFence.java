package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class ErectTheFence {

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
        int[][] hull = findConvexHull(points);

        System.out.println("Convex Hull Points:");
        for (int[] point : hull) {
            System.out.println(Arrays.toString(point));
        }
    }

    public static int[][] findConvexHull(int[][] points) {
        if (points.length <= 1) return points;

        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<int[]> hull = new ArrayList<>();

        for (int[] point : points) {
            while (hull.size() >= 2 && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(point);
        }

        int t = hull.size() + 1;
        for (int i = points.length - 2; i >= 0; i--) {
            while (hull.size() >= t && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(points[i]);
        }

        hull.remove(hull.size() - 1);
        return hull.toArray(new int[hull.size()][]);
    }

    public static int crossProduct(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - p[1]) - (q[1] - p[1]) * (r[0] - p[0]);
    }
}
