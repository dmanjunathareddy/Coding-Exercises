package com.softgroup.dsa.interview.leetcode;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], t = cell[2];
            if (x == n - 1 && y == n - 1) {
                return t;
            }
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    pq.offer(new int[]{newX, newY, Math.max(t, grid[newX][newY])});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwimInRisingWater solver = new SwimInRisingWater();
        int[][] grid = {
            {0, 2, 1, 3},
            {2, 3, 4, 5},
            {1, 2, 5, 4},
            {3, 4, 5, 0}
        };
        System.out.println(solver.swimInWater(grid)); // Output: 5
    }
}
