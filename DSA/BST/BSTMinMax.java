package com.softgroup.dsa.bst;

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class BSTMinMax {

	// Function to find the minimum value in a BST
	public static int findMin(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}

	// Function to find the maximum value in a BST
	public static int findMax(TreeNode root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.val;
	}

	public static void main(String[] args) {
		// Creating a simple BST
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(18);

		// Finding the minimum and maximum values in the BST
		int minValue = findMin(root);
		int maxValue = findMax(root);

		System.out.println("Minimum value in the BST: " + minValue);
		System.out.println("Maximum value in the BST: " + maxValue);
	}
}
