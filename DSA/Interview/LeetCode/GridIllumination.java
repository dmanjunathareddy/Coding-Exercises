package com.softgroup.dsa.interview.leetcode;
import java.util.*;

class GridIllumination {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> diagMap = new HashMap<>();
        Map<Integer, Integer> antiDiagMap = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();

        for (int[] lamp : lamps) {
            int row = lamp[0], col = lamp[1];
            if (lampSet.add((long) row << 32 | col)) {
                rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
                colMap.put(col, colMap.getOrDefault(col, 0) + 1);
                diagMap.put(row - col, diagMap.getOrDefault(row - col, 0) + 1);
                antiDiagMap.put(row + col, antiDiagMap.getOrDefault(row + col, 0) + 1);
            }
        }

        int[] result = new int[queries.length];
        int[][] directions = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0], col = queries[i][1];
            if (rowMap.getOrDefault(row, 0) > 0 || colMap.getOrDefault(col, 0) > 0 || diagMap.getOrDefault(row - col, 0) > 0 || antiDiagMap.getOrDefault(row + col, 0) > 0) {
                result[i] = 1;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && lampSet.remove((long) newRow << 32 | newCol)) {
                    rowMap.put(newRow, rowMap.get(newRow) - 1);
                    colMap.put(newCol, colMap.get(newCol) - 1);
                    diagMap.put(newRow - newCol, diagMap.get(newRow - newCol) - 1);
                    antiDiagMap.put(newRow + newCol, antiDiagMap.get(newRow + newCol) - 1);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        GridIllumination solution = new GridIllumination();
        int N = 5;
        int[][] lamps = {{0, 0}, {4, 4}};
        int[][] queries = {{1, 1}, {1, 0}};
        System.out.println(Arrays.toString(solution.gridIllumination(N, lamps, queries))); // Output: [1, 0]
        
        int[][] lamps2 = {{0, 0}, {1, 0}, {4, 4}};
        int[][] queries2 = {{1, 1}, {1, 0}, {1, 4}};
        System.out.println(Arrays.toString(solution.gridIllumination(N, lamps2, queries2))); // Output: [1, 1, 0]
    }
}
