package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class ZumaGame {
    
    public static void main(String[] args) {
        String board = "WRRBBW";
        String hand = "RB";
        System.out.println("Minimum steps to clear the board: " + findMinStep(board, hand));
    }

    public static int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) {
            handCount[c - 'A']++;
        }
        int result = helper(board, handCount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(String board, int[] handCount) {
        if (board.length() == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j <= board.length(); j++) {
            if (j < board.length() && board.charAt(j) == board.charAt(i)) {
                continue;
            }
            int ballsNeeded = 3 - (j - i);
            if (handCount[board.charAt(i) - 'A'] >= ballsNeeded) {
                int usedBalls = Math.max(ballsNeeded, 0);
                handCount[board.charAt(i) - 'A'] -= usedBalls;
                int temp = helper(board.substring(0, i) + board.substring(j), handCount);
                if (temp != Integer.MAX_VALUE) {
                    res = Math.min(res, usedBalls + temp);
                }
                handCount[board.charAt(i) - 'A'] += usedBalls;
            }
            i = j;
        }
        return res;
    }
}
