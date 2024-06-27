package com.softgroup.dsa.interview.leetcode;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

    private static class Cell {
        int row, col, height;
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] dir : directions) {
                int row = cell.row + dir[0];
                int col = cell.col + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    water += Math.max(0, cell.height - heightMap[row][col]);
                    pq.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                    visited[row][col] = true;
                }
            }
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWaterII trw = new TrappingRainWaterII();
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        System.out.println(trw.trapRainWater(heightMap)); // Output: 4
    }
}
