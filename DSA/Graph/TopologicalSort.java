package com.softgroup.dsa.graph;

import java.util.*;

public class TopologicalSort {
	public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
		List<Integer> sortedOrder = new ArrayList<>();
		if (numCourses <= 0)
			return sortedOrder;

		// Initialize the adjacency list and in-degree array
		HashMap<Integer, Integer> inDegree = new HashMap<>();
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			inDegree.put(i, 0);
			graph.put(i, new ArrayList<Integer>());
		}

		// Build the graph and in-degree array
		for (int[] prerequisite : prerequisites) {
			int parent = prerequisite[1];
			int child = prerequisite[0];
			graph.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}

		// Add all vertices with in-degree 0 to the queue
		Queue<Integer> sources = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0)
				sources.add(entry.getKey());
		}

		// Process each vertex in the queue and reduce the in-degree of its neighbors
		while (!sources.isEmpty()) {
			int vertex = sources.poll();
			sortedOrder.add(vertex);
			List<Integer> children = graph.get(vertex);
			for (int child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0)
					sources.add(child);
			}
		}

		// If the sorted order doesn't contain all vertices, there's a cycle
		if (sortedOrder.size() != numCourses)
			return new ArrayList<>();

		return sortedOrder;
	}

	public static void main(String[] args) {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		List<Integer> result = topologicalSort(4, prerequisites);
		System.out.println("Topological sort: " + result);
	}
}
