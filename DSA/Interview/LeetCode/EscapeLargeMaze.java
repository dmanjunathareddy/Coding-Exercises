package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class EscapeLargeMaze {

    private static final int MAX = 1_000_000; // Size of the grid
    private static final int DIRS = 4; // Number of directions (N, S, E, W)

    // Direction vectors for moving up, down, left, and right
    private static final int[][] DIRECTIONS = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }
        // We can escape if both source and target can reach enough open cells
        return bfs(source, blockedSet, target) && bfs(target, blockedSet, source);
    }

    private boolean bfs(int[] start, Set<String> blockedSet, int[] end) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start[0] + "," + start[1]);
        int steps = 0;

        while (!queue.isEmpty() && steps <= blockedSet.size()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (point[0] == end[0] && point[1] == end[1]) {
                    return true; // Reached target
                }

                for (int[] dir : DIRECTIONS) {
                    int newX = point[0] + dir[0];
                    int newY = point[1] + dir[1];
                    String newPoint = newX + "," + newY;

                    if (newX < 0 || newX >= MAX || newY < 0 || newY >= MAX ||
                        blockedSet.contains(newPoint) || visited.contains(newPoint)) {
                        continue;
                    }

                    queue.add(new int[]{newX, newY});
                    visited.add(newPoint);
                }
            }
            steps++;
        }
        return steps > blockedSet.size();
    }

    public static void main(String[] args) {
        EscapeLargeMaze solver = new EscapeLargeMaze();
        int[][] blocked = {{0,1},{1,0},{1,2},{2,1}};
        int[] source = {0,0};
        int[] target = {2,2};
        System.out.println(solver.isEscapePossible(blocked, source, target)); // Output: true
    }
}
