package com.softgroup.dsa.tree;

class TreeNodeSearch {
    int val;
    TreeNodeSearch left;
    TreeNodeSearch right;

    public TreeNodeSearch(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BSTForSearch {
    TreeNodeSearch root;

    public BSTForSearch() {
        this.root = null;
    }

    // Method to insert a node into the BST
    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNodeSearch insertNode(TreeNodeSearch root, int val) {
        if (root == null) {
            return new TreeNodeSearch(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    // Method to search for a node with a given value in the BST
    public boolean search(int val) {
        return searchNode(root, val);
    }

    private boolean searchNode(TreeNodeSearch root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        } else if (val < root.val) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }

    // Helper method to perform inorder traversal (for testing)
    public void inorder() {
        inorderTraversal(root);
    }

    private void inorderTraversal(TreeNodeSearch root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BSTForSearch bst = new BSTForSearch();
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(2);
        bst.insert(4);

        System.out.println("Inorder traversal of the BST:");
        bst.inorder(); // Output: 2 3 4 5 8

        int searchValue = 3;
        System.out.println("\nSearching for value " + searchValue + " in the BST:");
        boolean found = bst.search(searchValue);
        if (found) {
            System.out.println("Value " + searchValue + " found in the BST.");
        } else {
            System.out.println("Value " + searchValue + " not found in the BST.");
        }
    }
}
