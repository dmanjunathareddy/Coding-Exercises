package com.softgroup.dsa.interview.leetcode;
import java.util.Arrays;

public class TransformToChessboard {
    public int movesToChessboard(int[][] board) {
        int N = board.length;
        
        // Check for validity and compute the transformation patterns
        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        
        for (int i = 0; i < N; ++i) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) rowSwap++;
            if (board[0][i] == i % 2) colSwap++;
        }
        
        if (rowSum != N / 2 && rowSum != (N + 1) / 2) return -1;
        if (colSum != N / 2 && colSum != (N + 1) / 2) return -1;
        
        if (N % 2 == 1) {
            if (rowSwap % 2 == 1) rowSwap = N - rowSwap;
            if (colSwap % 2 == 1) colSwap = N - colSwap;
        } else {
            rowSwap = Math.min(rowSwap, N - rowSwap);
            colSwap = Math.min(colSwap, N - colSwap);
        }
        
        return (rowSwap + colSwap) / 2;
    }

    public static void main(String[] args) {
        TransformToChessboard solver = new TransformToChessboard();
        int[][] board = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        System.out.println(solver.movesToChessboard(board)); // Output: 2
    }
}
