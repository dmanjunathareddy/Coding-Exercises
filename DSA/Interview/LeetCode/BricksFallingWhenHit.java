package com.softgroup.dsa.interview.leetcode;
public class BricksFallingWhenHit {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int R = grid.length, C = grid[0].length;
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]] -= 1;
        }

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};
        int[] parent = new int[R * C + 1];
        int[] size = new int[R * C + 1];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    int i = r * C + c;
                    parent[i] = i;
                    size[i] = 1;
                }
            }
        }
        parent[R * C] = R * C;
        size[R * C] = 0;

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (xr == yr) return;
            if (xr == R * C || (yr != R * C && size[xr] >= size[yr])) {
                parent[yr] = xr;
                size[xr] += size[yr];
            } else {
                parent[xr] = yr;
                size[yr] += size[xr];
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    int i = r * C + c;
                    if (r == 0) {
                        union(i, R * C);
                    }
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
                            int j = nr * C + nc;
                            union(i, j);
                        }
                    }
                }
            }
        }

        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            grid[r][c] += 1;
            if (grid[r][c] == 1) {
                int prevRoofSize = size[find(R * C)];
                int index = r * C + c;
                if (r == 0) {
                    union(index, R * C);
                }
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
                        int neighborIndex = nr * C + nc;
                        union(index, neighborIndex);
                    }
                }
                int newRoofSize = size[find(R * C)];
                result[i] = Math.max(0, newRoofSize - prevRoofSize - 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BricksFallingWhenHit bfh = new BricksFallingWhenHit();
        int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = {{1, 0}};
        int[] result = bfh.hitBricks(grid, hits);
        for (int res : result) {
            System.out.print(res + " ");
        }
        // Output: 2
    }
}
