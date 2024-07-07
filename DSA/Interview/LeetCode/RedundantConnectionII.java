package com.softgroup.dsa.interview.leetcode;
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != 0) {
                candidate1 = new int[]{parent[v], v};
                candidate2 = new int[]{u, v};
                edge[1] = 0; // Invalidate this edge for now
            } else {
                parent[v] = u;
            }
        }

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            int u = edge[0], v = edge[1];
            if (!uf.union(u, v)) {
                return candidate1 == null ? edge : candidate1;
            }
        }

        return candidate2;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) {
                return false;
            }
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        RedundantConnectionII solution = new RedundantConnectionII();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}}; // Example test case
        int[] result = solution.findRedundantDirectedConnection(edges);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [2, 3]
    }
}
