package com.softgroup.dsa.arrayscom.softgroup.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGraph {
	private Map<Integer, List<Integer>> adjacencyList;

	public SimpleGraph() {
		this.adjacencyList = new HashMap<>();
	}

	public void addVertex(int vertex) {
		adjacencyList.put(vertex, new ArrayList<>());
	}

	public void addEdge(int source, int destination) {
		adjacencyList.get(source).add(destination);
		adjacencyList.get(destination).add(source);
	}

	public void printGraph() {
		for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
			int vertex = entry.getKey();
			List<Integer> neighbors = entry.getValue();

			System.out.print("Vertex " + vertex + " is connected to: ");
			for (int neighbor : neighbors) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SimpleGraph graph = new SimpleGraph();
		// Adding vertices
		for (int i = 1; i <= 5; i++) {
			graph.addVertex(i);
		}

		// Adding edges
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);

		// Printing the graph
		graph.printGraph();
	}
}
