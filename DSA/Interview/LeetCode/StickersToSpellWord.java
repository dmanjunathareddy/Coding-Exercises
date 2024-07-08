package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.Map;

public class StickersToSpellWord {

    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[][] stickerCounts = new int[stickers.length][26];

        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);
        return helper(memo, stickerCounts, target);
    }

    private int helper(Map<String, Integer> memo, int[][] stickerCounts, String target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int n = target.length();
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int[] sticker : stickerCounts) {
            if (sticker[target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (targetCount[i] > 0) {
                    for (int j = 0; j < Math.max(0, targetCount[i] - sticker[i]); j++) {
                        sb.append((char) ('a' + i));
                    }
                }
            }
            String s = sb.toString();
            int tmp = helper(memo, stickerCounts, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }

        memo.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return memo.get(target);
    }

    public static void main(String[] args) {
        StickersToSpellWord solver = new StickersToSpellWord();
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        System.out.println(solver.minStickers(stickers, target)); // Output: 3
    }
}
