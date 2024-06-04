package com.softgroup.dsa.interview;
import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int targetSum = 7;
        findPairs(numbers, targetSum);
    }

    public static void findPairs(int[] numbers, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            int complement = targetSum - number;

            if (map.containsKey(complement)) {
                System.out.println("Pair: (" + complement + ", " + number + ")");
            }

            map.put(number, complement);
        }
    }
}
