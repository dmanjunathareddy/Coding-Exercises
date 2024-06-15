package com.softgroup.dsa.interview.leetcode;
import java.util.*;

class Point {
    int x, y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int samePoint = 1;
            int sameX = 0;
            int currentMax = 0;

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint++;
                } else if (points[i].x == points[j].x) {
                    sameX++;
                } else {
                    int deltaX = points[i].x - points[j].x;
                    int deltaY = points[i].y - points[j].y;
                    int gcd = gcd(deltaX, deltaY);
                    deltaX /= gcd;
                    deltaY /= gcd;

                    String slope = deltaY + "/" + deltaX;
                    slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                    currentMax = Math.max(currentMax, slopeCount.get(slope));
                }
            }
            currentMax = Math.max(currentMax, sameX) + samePoint;
            maxPoints = Math.max(maxPoints, currentMax);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        MaxPointsOnLine solution = new MaxPointsOnLine();
        Point[] points = {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3),
            new Point(4, 4),
            new Point(1, 2),
            new Point(2, 3),
            new Point(3, 4)
        };
        System.out.println("Maximum points on a line: " + solution.maxPoints(points));
    }
}
