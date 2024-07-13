package com.softgroup.dsa.interview.leetcode;
public class CouplesHoldingHands {

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[row[i]] = i;
        }

        int swaps = 0;
        for (int i = 0; i < n; i += 2) {
            int first = row[i];
            int second = first ^ 1;

            if (row[i + 1] != second) {
                swaps++;
                int secondPos = position[second];
                swap(row, position, i + 1, secondPos);
            }
        }
        return swaps;
    }

    private void swap(int[] row, int[] position, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
        position[row[i]] = i;
        position[row[j]] = j;
    }

    public static void main(String[] args) {
        CouplesHoldingHands solution = new CouplesHoldingHands();
        int[] row = {0, 2, 1, 3};
        int result = solution.minSwapsCouples(row);
        System.out.println("Minimum number of swaps: " + result);
    }
}
