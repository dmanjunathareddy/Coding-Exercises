package com.softgroup.dsa.tree;

class TreeNodee {
	int val;
	TreeNodee left;
	TreeNodee right;

	public TreeNodee(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class BST {
	TreeNodee root;

	public BST() {
		this.root = null;
	}

	public void insert(int val) {
		root = insertNode(root, val);
	}

	private TreeNodee insertNode(TreeNodee root, int val) {
		if (root == null) {
			return new TreeNodee(val);
		}

		if (val < root.val) {
			root.left = insertNode(root.left, val);
		} else if (val > root.val) {
			root.right = insertNode(root.right, val);
		}

		return root;
	}

	// Helper method to perform inorder traversal (for testing)
	public void inorder() {
		inorderTraversal(root);
	}

	private void inorderTraversal(TreeNodee root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.val + " ");
			inorderTraversal(root.right);
		}
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(5);
		bst.insert(3);
		bst.insert(8);
		bst.insert(2);
		bst.insert(4);

		System.out.println("Inorder traversal of the BST:");
		bst.inorder(); // Output: 2 3 4 5 8
	}
}
