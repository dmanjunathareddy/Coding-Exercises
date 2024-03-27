package com.softgroup.dsa.graph;

import java.util.*;

public class GraphPathExits {
	private final int V;
	private final List<List<Integer>> adj;

	public GraphPathExits(int V) {
		this.V = V;
		adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	private boolean isReachableUtil(int start, int target, boolean[] visited) {
		if (start == target) {
			return true;
		}

		visited[start] = true;

		for (Integer neighbor : adj.get(start)) {
			if (!visited[neighbor] && isReachableUtil(neighbor, target, visited)) {
				return true;
			}
		}

		return false;
	}

	public boolean isReachable(int start, int target) {
		boolean[] visited = new boolean[V];
		return isReachableUtil(start, target, visited);
	}

	public static void main(String[] args) {
		GraphPathExits graph = new GraphPathExits(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		int start = 1;
		int target = 3;

		if (graph.isReachable(start, target)) {
			System.out.println("There is a path from " + start + " to " + target);
		} else {
			System.out.println("There is no path from " + start + " to " + target);
		}
	}
}
