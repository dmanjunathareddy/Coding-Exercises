package com.softgroup.dsa.interview;
import java.util.ArrayList;
import java.util.List;

class TernarySearchTree {

    // Node class representing each node in the TST
    private static class Node {
        char data;
        Node left, middle, right;
        boolean isEndOfString;

        Node(char data) {
            this.data = data;
            this.isEndOfString = false;
        }
    }

    private Node root;

    // Method to insert a word into the TST
    public void insert(String word) {
        root = insert(root, word.toCharArray(), 0);
    }

    private Node insert(Node node, char[] word, int index) {
        if (node == null) {
            node = new Node(word[index]);
        }

        if (word[index] < node.data) {
            node.left = insert(node.left, word, index);
        } else if (word[index] > node.data) {
            node.right = insert(node.right, word, index);
        } else {
            if (index + 1 < word.length) {
                node.middle = insert(node.middle, word, index + 1);
            } else {
                node.isEndOfString = true;
            }
        }
        return node;
    }

    // Method to find all words with the given prefix
    public List<String> autoComplete(String prefix) {
        List<String> result = new ArrayList<>();
        Node prefixNode = searchNode(root, prefix.toCharArray(), 0);
        if (prefixNode != null) {
            if (prefixNode.isEndOfString) {
                result.add(prefix);
            }
            collect(prefixNode.middle, new StringBuilder(prefix), result);
        }
        return result;
    }

    private Node searchNode(Node node, char[] prefix, int index) {
        if (node == null) {
            return null;
        }

        if (prefix[index] < node.data) {
            return searchNode(node.left, prefix, index);
        } else if (prefix[index] > node.data) {
            return searchNode(node.right, prefix, index);
        } else {
            if (index + 1 == prefix.length) {
                return node;
            }
            return searchNode(node.middle, prefix, index + 1);
        }
    }

    private void collect(Node node, StringBuilder prefix, List<String> result) {
        if (node == null) {
            return;
        }

        collect(node.left, prefix, result);

        prefix.append(node.data);
        if (node.isEndOfString) {
            result.add(prefix.toString());
        }
        collect(node.middle, prefix, result);
        prefix.deleteCharAt(prefix.length() - 1);

        collect(node.right, prefix, result);
    }

    public static void main(String[] args) {
        TernarySearchTree tst = new TernarySearchTree();

        // Insert words into the TST
        tst.insert("cat");
        tst.insert("cats");
        tst.insert("cap");
        tst.insert("cape");
        tst.insert("bat");
        tst.insert("bats");
        tst.insert("bath");
        tst.insert("batman");

        // Auto-complete for prefix "ca"
        System.out.println("Auto-complete results for 'ca': " + tst.autoComplete("ca"));
        // Auto-complete for prefix "bat"
        System.out.println("Auto-complete results for 'bat': " + tst.autoComplete("bat"));
        // Auto-complete for prefix "ba"
        System.out.println("Auto-complete results for 'ba': " + tst.autoComplete("ba"));
    }
}
