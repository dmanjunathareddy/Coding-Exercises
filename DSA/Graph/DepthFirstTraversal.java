package com.softgroup.dsa.graph;

import java.util.*;

public class DepthFirstTraversal {

    public static void dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");

        List<Integer> neighbors = graph.getOrDefault(start, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3, 4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Collections.singletonList(6));
        graph.put(4, Collections.singletonList(7));
        graph.put(5, Collections.singletonList(8));
        graph.put(6, Collections.emptyList());
        graph.put(7, Collections.emptyList());
        graph.put(8, Collections.emptyList());

        Set<Integer> visited = new HashSet<>();
        System.out.println("Depth First Traversal:");
        dfs(graph, 0, visited);
    }
}
