package com.softgroup.dsa.sorting;
// Node class representing a node in the binary search tree
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Class to perform Tree Sort
public class TreeSort {
    // Root of the Binary Search Tree
    Node root;

    // Constructor
    TreeSort() {
        root = null;
    }

    // Method to insert a new key into the binary search tree
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key into the binary search tree
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // A utility function to do in-order traversal of the tree
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method to perform Tree Sort
    void treeSort(int arr[]) {
        // Insert elements of the array into the binary search tree
        for (int key : arr) {
            insert(key);
        }

        // Perform in-order traversal to retrieve elements in sorted order
        inorderRec(root);
    }

    // Main method to test TreeSort
    public static void main(String args[]) {
        int arr[] = {5, 2, 8, 1, 4, 9, 3, 7, 6};
        TreeSort ts = new TreeSort();
        ts.treeSort(arr);
    }
}
