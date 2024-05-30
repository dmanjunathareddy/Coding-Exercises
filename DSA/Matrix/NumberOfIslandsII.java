package com.softgroup.dsa.matrix;
import java.util.*;

public class NumberOfIslandsII {
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        int count = 0;

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int index = r * n + c;
            if (parent[index] != -1) {
                result.add(count);
                continue;
            }

            parent[index] = index;
            count++;

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                int newIndex = nr * n + nc;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && parent[newIndex] != -1) {
                    int root1 = find(parent, index);
                    int root2 = find(parent, newIndex);

                    if (root1 != root2) {
                        parent[root1] = root2;
                        count--;
                    }
                }
            }
            result.add(count);
        }

        return result;
    }

    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 1}};
        System.out.println("Number of islands after each addLand operation: " + numIslands2(m, n, positions));
        // Output: [1, 1, 2, 3, 1]
    }
}
