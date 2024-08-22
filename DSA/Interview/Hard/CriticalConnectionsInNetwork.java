package com.softgroup.dsa.interview;
import java.util.*;

public class CriticalConnectionsInNetwork {

    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        int[] discovery = new int[n];
        int[] low = new int[n];
        Arrays.fill(discovery, -1);  // Mark all nodes as unvisited

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            if (discovery[i] == -1) {
                dfs(i, -1, discovery, low, graph, result);
            }
        }

        return result;
    }

    private void dfs(int node, int parent, int[] discovery, int[] low, List<Integer>[] graph, List<List<Integer>> result) {
        discovery[node] = low[node] = ++time;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;  // Ignore the edge leading back to the parent

            if (discovery[neighbor] == -1) {  // If the neighbor hasn't been visited
                dfs(neighbor, node, discovery, low, graph, result);
                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > discovery[node]) {  // Critical connection found
                    result.add(Arrays.asList(node, neighbor));
                }
            } else {  // If the neighbor has already been visited
                low[node] = Math.min(low[node], discovery[neighbor]);
            }
        }
    }

    public static void main(String[] args) {
        CriticalConnectionsInNetwork solution = new CriticalConnectionsInNetwork();

        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        List<List<Integer>> result = solution.criticalConnections(n, connections);
        System.out.println(result);  // Output: [[1, 3]]
    }
}
