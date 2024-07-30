package com.softgroup.dsa.interview.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsFinder {
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Initialize graph
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph from connections
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // Arrays to store discovery time and lowest reachable time
        int[] discoveryTime = new int[n];
        int[] low = new int[n];
        Arrays.fill(discoveryTime, -1); // Mark all nodes as unvisited

        List<List<Integer>> criticalConnections = new ArrayList<>();

        // Run DFS from node 0 (assuming the graph is connected)
        dfs(0, -1, discoveryTime, low, graph, criticalConnections);

        return criticalConnections;
    }

    private void dfs(int u, int parent, int[] discoveryTime, int[] low, List<Integer>[] graph, List<List<Integer>> criticalConnections) {
        discoveryTime[u] = low[u] = ++time; // Initialize discovery time and low value
        for (int v : graph[u]) {
            if (v == parent) {
                continue; // If v is the parent of u, skip it
            }

            if (discoveryTime[v] == -1) { // If v is not visited
                dfs(v, u, discoveryTime, low, graph, criticalConnections);

                // Check if the subtree rooted at v has a connection back to one of u's ancestors
                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree under v is below u in DFS tree
                if (low[v] > discoveryTime[u]) {
                    criticalConnections.add(Arrays.asList(u, v));
                }
            } else {
                // Update low value of u for parent function calls.
                low[u] = Math.min(low[u], discoveryTime[v]);
            }
        }
    }

    public static void main(String[] args) {
        CriticalConnectionsFinder finder = new CriticalConnectionsFinder();
        int n = 5;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(3, 4));

        List<List<Integer>> result = finder.criticalConnections(n, connections);
        for (List<Integer> connection : result) {
            System.out.println(connection);
        }
    }
}
