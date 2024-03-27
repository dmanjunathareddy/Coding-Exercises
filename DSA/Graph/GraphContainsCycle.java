package com.softgroup.dsa.graph;

import java.util.*;

public class GraphContainsCycle {
	private final int V;
	private final List<List<Integer>> adj;

	public GraphContainsCycle(int V) {
		this.V = V;
		adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
		if (!visited[v]) {
			visited[v] = true;
			recStack[v] = true;

			for (Integer neighbor : adj.get(v)) {
				if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack)) {
					return true;
				} else if (recStack[neighbor]) {
					return true;
				}
			}
		}
		recStack[v] = false;
		return false;
	}

	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GraphContainsCycle graph = new GraphContainsCycle(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (graph.isCyclic()) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't contain cycle");
		}
	}
}
