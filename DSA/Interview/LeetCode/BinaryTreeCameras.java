package com.softgroup.dsa.interview.leetcode;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeCameras {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        System.out.println(minCameraCover(root));
    }

    static int cameras = 0;

    public static int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) cameras++;
        return cameras;
    }

    // Return 0 if a node needs a camera, 1 if it's covered, 2 if it has a camera.
    private static int dfs(TreeNode node) {
        if (node == null) return 1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {
            cameras++;
            return 2;
        }
        if (left == 2 || right == 2) return 1;
        return 0;
    }
}
