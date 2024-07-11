package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class ContainVirus {

    public int containVirus(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalWalls = 0;

        while (true) {
            List<Set<Integer>> regions = new ArrayList<>();
            List<Integer> wallsNeeded = new ArrayList<>();
            List<Set<Integer>> threats = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> threat = new HashSet<>();
                        int[] walls = new int[1];
                        dfs(grid, i, j, visited, region, threat, walls);
                        regions.add(region);
                        threats.add(threat);
                        wallsNeeded.add(walls[0]);
                    }
                }
            }

            if (regions.isEmpty()) break;

            int mostThreateningRegion = 0;
            for (int i = 1; i < threats.size(); i++) {
                if (threats.get(i).size() > threats.get(mostThreateningRegion).size()) {
                    mostThreateningRegion = i;
                }
            }

            totalWalls += wallsNeeded.get(mostThreateningRegion);
            for (int idx : regions.get(mostThreateningRegion)) {
                int x = idx / n, y = idx % n;
                grid[x][y] = -1;
            }

            for (int i = 0; i < regions.size(); i++) {
                if (i == mostThreateningRegion) continue;
                for (int idx : threats.get(i)) {
                    int x = idx / n, y = idx % n;
                    grid[x][y] = 1;
                }
            }
        }

        return totalWalls;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, Set<Integer> region, Set<Integer> threat, int[] walls) {
        int m = grid.length, n = grid[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        visited[x][y] = true;
        region.add(x * n + y);

        for (int d = 0; d < 4; d++) {
            int nx = x + dirs[d], ny = y + dirs[d + 1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(grid, nx, ny, visited, region, threat, walls);
                } else if (grid[nx][ny] == 0) {
                    threat.add(nx * n + ny);
                    walls[0]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        ContainVirus solution = new ContainVirus();
        int[][] grid = {
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution.containVirus(grid)); // Output: 10
    }
}
