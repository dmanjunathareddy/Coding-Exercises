package com.softgroup.dsa.interview.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    private class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyCountMap;
    private Node head;
    private Node tail;

    public AllOne() {
        keyCountMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (!keyCountMap.containsKey(key)) {
            if (head.next.count != 1) {
                addNodeAfter(head, new Node(1));
            }
            head.next.keys.add(key);
            keyCountMap.put(key, head.next);
        } else {
            Node node = keyCountMap.get(key);
            Node nextNode = node.next;
            if (nextNode.count != node.count + 1) {
                nextNode = new Node(node.count + 1);
                addNodeAfter(node, nextNode);
            }
            nextNode.keys.add(key);
            keyCountMap.put(key, nextNode);
            removeKeyFromNode(node, key);
        }
    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) return;

        Node node = keyCountMap.get(key);
        if (node.count == 1) {
            keyCountMap.remove(key);
            removeKeyFromNode(node, key);
            return;
        }
        Node prevNode = node.prev;
        if (prevNode.count != node.count - 1) {
            prevNode = new Node(node.count - 1);
            addNodeAfter(node.prev, prevNode);
        }
        prevNode.keys.add(key);
        keyCountMap.put(key, prevNode);
        removeKeyFromNode(node, key);
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    private void addNodeAfter(Node prevNode, Node newNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeKeyFromNode(Node node, String key) {
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            removeNodeFromList(node);
        }
    }

    private void removeNodeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // Output: "hello"
        System.out.println(allOne.getMinKey()); // Output: "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // Output: "hello"
        System.out.println(allOne.getMinKey()); // Output: "leet"
    }
}
