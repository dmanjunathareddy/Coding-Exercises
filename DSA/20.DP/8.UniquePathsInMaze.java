package com.softgroup.dsa.dp;

public class UniquePathsInMaze {
	public static int uniquePaths(int[][] maze) {
		int m = maze.length;
		int n = maze[0].length;

		// Create a dp array to store the number of unique paths to reach each cell
		int[][] dp = new int[m][n];

		// Base case: there is only one way to reach cells in the first row or first
		// column
		for (int i = 0; i < m; i++) {
			if (maze[i][0] == 0) {
				dp[i][0] = 1;
			} else {
				break; // If there's a blockage, stop further traversal in this row
			}
		}
		for (int j = 0; j < n; j++) {
			if (maze[0][j] == 0) {
				dp[0][j] = 1;
			} else {
				break; // If there's a blockage, stop further traversal in this column
			}
		}

		// Iterate through the maze to fill in the dp array
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (maze[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Unique paths to reach (i, j) equals sum of paths from
															// (i-1, j) and (i, j-1)
				}
			}
		}

		return dp[m - 1][n - 1]; // Return the number of unique paths to reach the bottom-right corner
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, 0 } };
		System.out.println("Total number of unique paths: " + uniquePaths(maze));
	}
}
