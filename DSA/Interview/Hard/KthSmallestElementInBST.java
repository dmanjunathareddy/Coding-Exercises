package com.softgroup.dsa.interview;
public class KthSmallestElementInBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing the BST
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInBST finder = new KthSmallestElementInBST();
        int k = 1;
        int kthSmallest = finder.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + kthSmallest);

        k = 2;
        kthSmallest = finder.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + kthSmallest);
    }
}
