package com.softgroup.dsa.matrix;
public class LongestIncreasingPath {
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }
        
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int m = matrix.length, n = matrix[0].length;
        int max = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, cache);
                max = Math.max(max, len);
            }
        }
        
        cache[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println("Longest increasing path length: " + longestIncreasingPath(matrix)); // Output: 4
    }
}
