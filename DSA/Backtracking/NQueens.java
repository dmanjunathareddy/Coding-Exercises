package com.softgroup.dsa.backtracking;

public class NQueens {
	private int[] queens;
	private int n;

	public void solveNQueens(int n) {
		this.n = n;
		queens = new int[n];
		placeQueen(0);
	}

	private void placeQueen(int row) {
		if (row == n) {
			printQueens();
			return;
		}
		for (int col = 0; col < n; col++) {
			if (isValidPlacement(row, col)) {
				queens[row] = col;
				placeQueen(row + 1);
			}
		}
	}

	private boolean isValidPlacement(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (queens[i] == col || Math.abs(queens[i] - col) == row - i)
				return false;
		}
		return true;
	}

	private void printQueens() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (queens[i] == j)
					System.out.print("Q ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		NQueens nQueens = new NQueens();
		nQueens.solveNQueens(4); // Change the parameter to the desired board size
	}
}
