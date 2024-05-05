package com.softgroup.dsa.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }

        for (int col : cols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setMatrixZeroes.setZeroes(matrix);
        System.out.println("Matrix with Zeroes Set:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
