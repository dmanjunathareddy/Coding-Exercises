package com.softgroup.dsa.graph;

public class ClosedIslands {
	public int closedIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		// Mark boundary lands with water
		for (int i = 0; i < rows; i++) {
			if (grid[i][0] == 0) {
				dfs(grid, i, 0);
			}
			if (grid[i][cols - 1] == 0) {
				dfs(grid, i, cols - 1);
			}
		}

		for (int j = 0; j < cols; j++) {
			if (grid[0][j] == 0) {
				dfs(grid, 0, j);
			}
			if (grid[rows - 1][j] == 0) {
				dfs(grid, rows - 1, j);
			}
		}

		// Count closed islands
		for (int i = 1; i < rows - 1; i++) {
			for (int j = 1; j < cols - 1; j++) {
				if (grid[i][j] == 0) {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	private void dfs(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 0) {
			return;
		}

		grid[row][col] = 1; // Mark as visited

		// Explore neighbors
		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}

	public static void main(String[] args) {
		ClosedIslands closedIslands = new ClosedIslands();
		int[][] grid = { { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		int closedIslandCount = closedIslands.closedIsland(grid);
		System.out.println("Number of closed islands: " + closedIslandCount);
	}
}

