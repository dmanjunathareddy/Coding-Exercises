package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(stones[0]).add(1);

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            Set<Integer> steps = map.get(stone);
            for (int step : steps) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                if (map.containsKey(reach)) {
                    if (step - 1 > 0) {
                        map.get(reach).add(step - 1);
                    }
                    map.get(reach).add(step);
                    map.get(reach).add(step + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FrogJump fj = new FrogJump();
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(fj.canCross(stones)); // Output: true

        int[] stones2 = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(fj.canCross(stones2)); // Output: false
    }
}
