package com.softgroup.dsa.interview.leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        // Remove the trailing comma
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(node.left);
            }
            index++;
            if (!nodes[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(node.right);
            }
            index++;
        }
        
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        
        // Example to serialize and deserialize a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized: " + codec.serialize(deserializedRoot)); // Should match the original serialization
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
