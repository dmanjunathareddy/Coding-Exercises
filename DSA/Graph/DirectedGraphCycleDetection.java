package com.softgroup.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedGraphCycleDetection {

	private static boolean hasCycle(Map<Integer, List<Integer>> graph) {
		Set<Integer> visited = new HashSet<>();
		Set<Integer> recursionStack = new HashSet<>();

		for (Integer node : graph.keySet()) {
			if (dfs(node, graph, visited, recursionStack)) {
				return true;
			}
		}

		return false;
	}

	private static boolean dfs(Integer node, Map<Integer, List<Integer>> graph, Set<Integer> visited,
			Set<Integer> recursionStack) {
		if (recursionStack.contains(node)) {
			return true; // Cycle detected
		}

		if (visited.contains(node)) {
			return false; // Node has been visited already
		}

		visited.add(node);
		recursionStack.add(node);

		List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
		for (Integer neighbor : neighbors) {
			if (dfs(neighbor, graph, visited, recursionStack)) {
				return true;
			}
		}

		recursionStack.remove(node);

		return false;
	}

	public static void main(String[] args) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		graph.put(0, Arrays.asList(1, 2));
		graph.put(1, Collections.singletonList(2));
		graph.put(2, Collections.singletonList(0));
		graph.put(3, Collections.singletonList(3));

		boolean hasCycle = hasCycle(graph);
		if (hasCycle) {
			System.out.println("The graph contains a cycle.");
		} else {
			System.out.println("The graph does not contain a cycle.");
		}
	}
}
