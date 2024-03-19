package com.softgroup.dsa.graph;

import java.util.*;

class BiconnectedComponentOfAnUndirectedGraph {
	private int V; // Number of vertices
	private List<List<Integer>> adj; // Adjacency list representation of graph
	private int time = 0;
	private List<List<Integer>> biconnectedComponents; // List of biconnected components

	BiconnectedComponentOfAnUndirectedGraph(int v) {
		V = v;
		adj = new ArrayList<>(v);
		for (int i = 0; i < v; ++i)
			adj.add(new LinkedList<>());
		biconnectedComponents = new ArrayList<>();
	}

	void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}

	void dfs(int u, int parent, int[] disc, int[] low, Stack<List<Integer>> st) {
		disc[u] = low[u] = ++time;
		int children = 0;
		boolean isArticulation = false;

		for (int v : adj.get(u)) {
			if (disc[v] == 0) {
				children++;
				st.push(Arrays.asList(u, v));
				dfs(v, u, disc, low, st);
				low[u] = Math.min(low[u], low[v]);

				// Check for articulation point
				if (low[v] >= disc[u]) {
					isArticulation = true;
					List<Integer> component = new ArrayList<>();
					while (!st.isEmpty()) {
						List<Integer> edge = st.pop();
						component.add(edge.get(0));
						component.add(edge.get(1));
						if (edge.get(0) == u && edge.get(1) == v)
							break;
					}
					biconnectedComponents.add(component);
				}
			} else if (v != parent && disc[v] < low[u]) {
				low[u] = disc[v];
				st.push(Arrays.asList(u, v));
			}
		}

		// Check for root articulation
		if (parent == -1 && children > 1)
			isArticulation = true;

		if (isArticulation) {
			List<Integer> component = new ArrayList<>();
			while (!st.isEmpty()) {
				List<Integer> edge = st.pop();
				component.add(edge.get(0));
				component.add(edge.get(1));
				if (edge.get(0) == u && edge.get(1) == parent)
					break;
			}
			biconnectedComponents.add(component);
		}
	}

	void findBiconnectedComponents() {
		int[] disc = new int[V];
		int[] low = new int[V];
		Stack<List<Integer>> st = new Stack<>();

		for (int i = 0; i < V; i++)
			if (disc[i] == 0)
				dfs(i, -1, disc, low, st);
	}

	void printBiconnectedComponents() {
		for (int i = 0; i < biconnectedComponents.size(); i++) {
			System.out.println("Biconnected Component " + (i + 1));
			for (int j = 0; j < biconnectedComponents.get(i).size(); j += 2)
				System.out.println(
						biconnectedComponents.get(i).get(j) + " -- " + biconnectedComponents.get(i).get(j + 1));
			System.out.println();
		}
	}
}

public class BiconnectedComponents {
	public static void main(String[] args) {
		BiconnectedComponentOfAnUndirectedGraph g = new BiconnectedComponentOfAnUndirectedGraph(7);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(1, 6);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		g.findBiconnectedComponents();
		g.printBiconnectedComponents();
	}
}
