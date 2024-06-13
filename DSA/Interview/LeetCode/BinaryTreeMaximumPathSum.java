package com.softgroup.dsa.interview.leetcode;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeMaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the maximum contribution of left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Current node's max path sum considering the best left and right gains
        int priceNewPath = node.val + leftGain + rightGain;

        // Update maxSum if it's better to start a new path at the current node
        maxSum = Math.max(maxSum, priceNewPath);

        // Return the max gain if continuing the same path
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        System.out.println(solution.maxPathSum(root)); // Output: 42
    }
}
