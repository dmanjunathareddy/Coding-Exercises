package com.softgroup.dsa.interview;
import java.util.*;

public class DFSTreeTraversal {

    // Function to perform DFS on the tree
    private static void dfs(Map<Integer, List<Integer>> adjacencyList, int node, boolean[] visited) {
        // Mark the current node as visited
        visited[node] = true;
        System.out.print(node + " ");  // Perform some operation on the node

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Create an adjacency list representation of the tree
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Add edges
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 2, 4);
        addEdge(adjacencyList, 2, 5);
        addEdge(adjacencyList, 3, 6);
        addEdge(adjacencyList, 3, 7);

        // Number of nodes (assuming nodes are labeled from 1 to 7)
        int n = 7;
        boolean[] visited = new boolean[n + 1];  // +1 because node labels start from 1

        // Perform DFS starting from node 1
        System.out.println("DFS Traversal starting from node 1:");
        dfs(adjacencyList, 1, visited);
    }

    // Function to add an edge to the tree (since it's an undirected tree, add both ways)
    private static void addEdge(Map<Integer, List<Integer>> adjacencyList, int u, int v) {
        adjacencyList.putIfAbsent(u, new ArrayList<>());
        adjacencyList.putIfAbsent(v, new ArrayList<>());
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }
}
