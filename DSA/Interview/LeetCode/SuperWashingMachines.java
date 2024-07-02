package com.softgroup.dsa.interview.leetcode;
public class SuperWashingMachines {

    public static void main(String[] args) {
        int[] machines = {1, 0, 5};
        System.out.println("Minimum number of moves: " + findMinMoves(machines));
    }

    public static int findMinMoves(int[] machines) {
        int total = 0;
        for (int load : machines) {
            total += load;
        }

        if (total % machines.length != 0) {
            return -1;
        }

        int target = total / machines.length;
        int maxMoves = 0;
        int currSum = 0;

        for (int load : machines) {
            int diff = load - target;
            currSum += diff;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(currSum), diff));
        }

        return maxMoves;
    }
}
