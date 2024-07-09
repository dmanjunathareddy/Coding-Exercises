package com.softgroup.dsa.interview.leetcode;
import java.util.*;

public class RandomPickWithBlacklist {
    private int range;
    private Random random;
    private Map<Integer, Integer> map;

    public RandomPickWithBlacklist(int N, int[] blacklist) {
        range = N - blacklist.length;
        random = new Random();
        map = new HashMap<>();

        Set<Integer> blacklistSet = new HashSet<>();
        for (int b : blacklist) {
            blacklistSet.add(b);
        }

        int last = N - 1;
        for (int b : blacklist) {
            if (b < range) {
                while (blacklistSet.contains(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int r = random.nextInt(range);
        return map.getOrDefault(r, r);
    }

    public static void main(String[] args) {
        int N = 10;
        int[] blacklist = {2, 3, 5};

        RandomPickWithBlacklist picker = new RandomPickWithBlacklist(N, blacklist);
        for (int i = 0; i < 10; i++) {
            System.out.println(picker.pick());
        }
    }
}
