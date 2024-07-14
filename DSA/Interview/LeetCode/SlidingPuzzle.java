package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class SlidingPuzzle {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String TARGET = "123450";

    public int slidingPuzzle(int[][] board) {
        String start = boardToString(board);
        if (start.equals(TARGET)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        int moves = 0;
        while (!queue.isEmpty()) {
            moves++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                for (String next : getNextStates(current)) {
                    if (next.equals(TARGET)) return moves;
                    if (visited.add(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        int zeroIndex = current.indexOf('0');
        int x = zeroIndex / 3;
        int y = zeroIndex % 3;

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                char[] newBoard = current.toCharArray();
                int newIndex = newX * 3 + newY;
                newBoard[zeroIndex] = newBoard[newIndex];
                newBoard[newIndex] = '0';
                nextStates.add(new String(newBoard));
            }
        }
        return nextStates;
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SlidingPuzzle solver = new SlidingPuzzle();
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(solver.slidingPuzzle(board)); // Output: 1
    }
}
