package com.softgroup.dsa.matrix;
public class FindCelebrity {
    private static int[][] matrix;
    
    public static void setMatrix(int[][] m) {
        matrix = m;
    }

    public static boolean knows(int a, int b) {
        return matrix[a][b] == 1;
    }

    public static int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] party = {
            {0, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };
        setMatrix(party);
        int n = 3;
        int result = findCelebrity(n);
        System.out.println("Celebrity ID: " + (result == -1 ? "No Celebrity" : result)); // Output: 2
    }
}
