package com.softgroup.dsa.interview;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {

	public void connect(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode prev = null;

			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queue.poll();

				if (prev != null) {
					prev.next = currentNode;
				}
				prev = currentNode;

				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
		}
	}

	// Helper method to print next pointers of each level
	public void printLevels(TreeNode root) {
		while (root != null) {
			TreeNode current = root;
			while (current != null) {
				System.out.print(current.val + " -> ");
				current = current.next;
			}
			System.out.println("NULL");

			if (root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
	}

	public static void main(String[] args) {
		// Creating a sample tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);

		ConnectNodesAtSameLevel solution = new ConnectNodesAtSameLevel();
		solution.connect(root);

		// Print the levels to verify
		solution.printLevels(root);
	}

}

class TreeNode {
	int val;
	TreeNode left, right, next;

	TreeNode(int x) {
		val = x;
		left = right = next = null;
	}
}
