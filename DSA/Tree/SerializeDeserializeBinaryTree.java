package com.softgroup.dsa.tree;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class SerializeDeserializeBinaryTree {
	// Serialization
	public String serialize(TreeNode root) {
		if (root == null)
			return "null";

		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}

	private void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null").append(",");
			return;
		}

		sb.append(root.val).append(",");
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}

	// Deserialization
	public TreeNode deserialize(String data) {
		if (data.equals("null"))
			return null;

		String[] dataArray = data.split(",");
		Queue<String> queue = new LinkedList<>(Arrays.asList(dataArray));
		return deserializeHelper(queue);
	}

	private TreeNode deserializeHelper(Queue<String> queue) {
		String val = queue.poll();
		if (val.equals("null"))
			return null;

		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = deserializeHelper(queue);
		node.right = deserializeHelper(queue);
		return node;
	}

	// Example usage
	public static void main(String[] args) {
		SerializeDeserializeBinaryTree serializer = new SerializeDeserializeBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		String serialized = serializer.serialize(root);
		System.out.println("Serialized: " + serialized);

		TreeNode deserialized = serializer.deserialize(serialized);
		System.out.println("Deserialized left child: " + deserialized.left.val);
		System.out.println("Deserialized right child: " + deserialized.right.val);
	}
}
