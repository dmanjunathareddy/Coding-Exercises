package com.softgroup.dsa.interview.leetcode;
public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (sx == tx && sy <= ty && (ty - sy) % sx == 0) {
            return true;
        }
        if (sy == ty && sx <= tx && (tx - sx) % sy == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ReachingPoints solver = new ReachingPoints();
        System.out.println(solver.reachingPoints(1, 1, 3, 5)); // Output: true
        System.out.println(solver.reachingPoints(1, 1, 2, 2)); // Output: false
        System.out.println(solver.reachingPoints(1, 1, 1, 1)); // Output: true
    }
}
