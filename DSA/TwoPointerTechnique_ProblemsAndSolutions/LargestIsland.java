package com.softgroup.dsa.interview;

import java.util.*;

public class LargestIsland {
    private static final int[] DIRS = {0, 1, 0, -1, 0};

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] idGrid = new int[n][n];
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2; // Start island IDs from 2 to distinguish from 0 and 1
        int maxIslandSize = 0;

        // Identify all islands and calculate their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && idGrid[i][j] == 0) {
                    int size = dfs(grid, idGrid, i, j, islandId);
                    islandSize.put(islandId, size);
                    maxIslandSize = Math.max(maxIslandSize, size);
                    islandId++;
                }
            }
        }

        // If the entire grid is one island, return its size
        if (maxIslandSize == n * n) {
            return maxIslandSize;
        }

        // Check each 0 to see the size of the island we can create by changing it to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visitedIslands = new HashSet<>();
                    int potentialSize = 1; // Include the cell itself
                    for (int d = 0; d < 4; d++) {
                        int ni = i + DIRS[d];
                        int nj = j + DIRS[d + 1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            int id = idGrid[ni][nj];
                            if (id > 1 && visitedIslands.add(id)) {
                                potentialSize += islandSize.get(id);
                            }
                        }
                    }
                    maxIslandSize = Math.max(maxIslandSize, potentialSize);
                }
            }
        }

        return maxIslandSize;
    }

    private static int dfs(int[][] grid, int[][] idGrid, int i, int j, int islandId) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 || idGrid[i][j] != 0) {
            return 0;
        }
        idGrid[i][j] = islandId;
        int size = 1;
        for (int d = 0; d < 4; d++) {
            size += dfs(grid, idGrid, i + DIRS[d], j + DIRS[d + 1], islandId);
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 1, 0},
            {1, 1, 0, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 1}
        };
        System.out.println("Largest Island Size: " + largestIsland(grid)); // Output should be the size of the largest possible island after changing one 0 to 1
    }
}
