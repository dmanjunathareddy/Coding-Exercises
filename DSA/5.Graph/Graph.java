package com.softgroup.dsa.arrayscom.softgroup.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

	private Map<Integer, List<Integer>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<>();
	}

	public void addVertex(int vertex) {
		adjacencyList.put(vertex, new ArrayList<>());
	}

	public void addEdges(int source, int destination) {
		if (!adjacencyList.containsKey(source)) {
			addVertex(source);
		}
		if (!adjacencyList.containsKey(destination)) {
			addVertex(destination);
		}
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

		Graph graph = new Graph();

		for (int i = 0; i < 5; i++) {
			graph.addVertex(i);
		}

		graph.addEdges(1, 2);
		graph.addEdges(2, 3);
		graph.addEdges(3, 4);
		graph.addEdges(3, 5);

		graph.printGraph();
	}
}
