package com.softgroup.dsa.interview;
import java.util.ArrayList;
import java.util.List;

public class Bipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // Create the adjacency list for the graph
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        // Array to store the color of each node (0: uncolored, 1: color1, -1: color2)
        int[] colors = new int[N + 1];

        // Try to color each component
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, int[] colors, int node, int color) {
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == 0) {
                if (!dfs(graph, colors, neighbor, -color)) {
                    return false;
                }
            } else if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Bipartition solution = new Bipartition();

        int N1 = 4;
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(solution.possibleBipartition(N1, dislikes1)); // Output: true

        int N2 = 3;
        int[][] dislikes2 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(solution.possibleBipartition(N2, dislikes2)); // Output: false
    }
}
