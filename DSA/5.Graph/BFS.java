package com.softgroup.dsa.arrayscom.softgroup.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static class Graph {
		private int V; // Number of vertices
		private LinkedList<Integer>[] adj; // Adjacency list representation of the graph

		public Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i) {
				adj[i] = new LinkedList<>();
			}
		}

		// Add an edge to the graph
		public void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// BFS traversal starting from source s
		public void BFS(int s) {
			// Mark all vertices as not visited
			boolean[] visited = new boolean[V];

			// Create a queue for BFS
			Queue<Integer> queue = new LinkedList<>();

			// Mark the current node as visited and enqueue it
			visited[s] = true;
			queue.add(s);

			while (!queue.isEmpty()) {
				// Dequeue a vertex from the queue and print it
				s = queue.poll();
				System.out.print(s + " ");

				// Get all adjacent vertices of the dequeued vertex
				// If an adjacent vertex has not been visited, mark it visited and enqueue it
				for (int neighbor : adj[s]) {
					if (!visited[neighbor]) {
						visited[neighbor] = true;
						queue.add(neighbor);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// Create a sample graph
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);

		System.out.println("BFS starting from vertex 0:");
		graph.BFS(0);
	}
}
