package com.softgroup.dsa.graph;

import java.util.*;

public class LevelOfNodes {
	static class TreeNode {
		int val;
		List<TreeNode> children;

		public TreeNode(int val) {
			this.val = val;
			this.children = new ArrayList<>();
		}
	}

	public static Map<TreeNode, Integer> findLevels(TreeNode root) {
		Map<TreeNode, Integer> levels = new HashMap<>();
		if (root == null)
			return levels;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		levels.put(root, 0);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int level = levels.get(node);

			for (TreeNode child : node.children) {
				levels.put(child, level + 1);
				queue.offer(child);
			}
		}

		return levels;
	}

	public static void main(String[] args) {
		// Constructing a tree
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		root.children.add(node2);
		root.children.add(node3);
		node2.children.add(node4);
		node2.children.add(node5);
		node3.children.add(node6);

		// Find levels of nodes
		Map<TreeNode, Integer> levels = findLevels(root);

		// Print levels of nodes
		for (Map.Entry<TreeNode, Integer> entry : levels.entrySet()) {
			System.out.println("Node: " + entry.getKey().val + ", Level: " + entry.getValue());
		}
	}
}
