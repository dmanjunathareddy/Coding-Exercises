package com.softgroup.dsa.arrayscom.softgroup.dsa.graph;

import java.util.*;

public class TopologicalSort {
	private Stack<Integer> stack;
	private boolean[] visited;
	private List<List<Integer>> adjList;

	public TopologicalSort(int vertices) {
		stack = new Stack<>();
		visited = new boolean[vertices];
		adjList = new ArrayList<>(vertices);

		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	public void addEdge(int source, int destination) {
		adjList.get(source).add(destination);
	}

	private void dfs(int vertex) {
		visited[vertex] = true;
		for (int neighbor : adjList.get(vertex)) {
			if (!visited[neighbor]) {
				dfs(neighbor);
			}
		}
		stack.push(vertex);
	}

	public void topologicalSort() {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		// Printing the result
		System.out.print("Topological Sort: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		int vertices = 6;
		TopologicalSort graph = new TopologicalSort(vertices);

		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		graph.topologicalSort();
	}
}
