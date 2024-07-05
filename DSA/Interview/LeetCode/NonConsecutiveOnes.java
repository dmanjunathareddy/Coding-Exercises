package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.List;

public class NonConsecutiveOnes {
    public static List<Integer> generateNonConsecutive(int n) {
        List<Integer> result = new ArrayList<>();
        generateNonConsecutiveHelper(n, 0, 0, result);
        return result;
    }

    private static void generateNonConsecutiveHelper(int n, int pos, int current, List<Integer> result) {
        if (pos == n) {
            result.add(current);
            return;
        }

        generateNonConsecutiveHelper(n, pos + 1, current << 1, result);

        if (pos == 0 || (current & 1) == 0) {
            generateNonConsecutiveHelper(n, pos + 1, (current << 1) | 1, result);
        }
    }

    public static void main(String[] args) {
        int n = 3;  // Number of bits
        List<Integer> result = generateNonConsecutive(n);
        for (int num : result) {
            System.out.println(Integer.toBinaryString(num));
        }
    }
}
