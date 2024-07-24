package com.softgroup.dsa.interview.leetcode;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RecoverTreeFromPreorder {

    public static TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < traversal.length()) {
            int level = 0;
            // Count the dashes to determine the depth
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                level++;
                i++;
            }
            // Read the number for the current node
            int start = i;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                i++;
            }
            int value = Integer.parseInt(traversal.substring(start, i));
            TreeNode node = new TreeNode(value);
            
            // Adjust the stack to have the correct parent for this node
            while (stack.size() > level) {
                stack.pop();
            }
            // Attach the node to the correct parent
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        // The first node in the stack is the root of the tree
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String traversal = "1-2--3--4-5--6--7";
        TreeNode root = recoverFromPreorder(traversal);

        // Function to print the tree can be added here for verification
    }
}
