package com.softgroup.dsa.interview.leetcode;
import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int length = 0;

        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, length, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == length) {
                length++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes rde = new RussianDollEnvelopes();
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(rde.maxEnvelopes(envelopes)); // Output: 3
    }
}
