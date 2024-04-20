package com.softgroup.dsa.search;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListSearch {

    // Function to search for a value in a linked list
    public static ListNode search(ListNode head, int target) {
        // Start from the head of the list
        ListNode current = head;

        // Traverse the list until current node becomes null or target is found
        while (current != null) {
            // If the current node's value matches the target, return the node
            if (current.val == target) {
                return current;
            }
            // Move to the next node
            current = current.next;
        }

        // If target is not found, return null
        return null;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 3 -> 5 -> 7 -> 9
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        // Value to search for
        int target = 5;

        // Perform search
        ListNode result = search(head, target);

        // Output the result
        if (result != null) {
            System.out.println("Element " + target + " found in the linked list.");
        } else {
            System.out.println("Element " + target + " not found in the linked list.");
        }
    }
}
