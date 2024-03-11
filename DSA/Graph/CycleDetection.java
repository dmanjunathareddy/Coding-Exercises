package com.softgroup.dsa.arrayscom.softgroup.dsa.graph;

import java.util.*;

public class CycleDetection {
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private boolean[] inStack;

    public CycleDetection(int vertices) {
        adjList = new ArrayList<>(vertices);
        visited = new boolean[vertices];
        inStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    private boolean hasCycle(int vertex) {
        visited[vertex] = true;
        inStack[vertex] = true;

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor)) {
                    return true;
                }
            } else if (inStack[neighbor]) {
                return true;
            }
        }

        inStack[vertex] = false;
        return false;
    }

    public boolean detectCycle() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (hasCycle(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        CycleDetection graph = new CycleDetection(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1); // Introducing a cycle

        boolean hasCycle = graph.detectCycle();
        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
