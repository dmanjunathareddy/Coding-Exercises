package com.softgroup.dsa.search;

public class CircularLinkedListSearch {

	// Function to search for a value in a circular linked list
	public static boolean search(ListNode head, int target) {
		// If list is empty, return false
		if (head == null) {
			return false;
		}

		ListNode current = head;
		do {
			// If current node's value matches the target, return true
			if (current.val == target) {
				return true;
			}
			// Move to the next node
			current = current.next;
		} while (current != head); // Stop when we reach the head node again

		// If target is not found, return false
		return false;
	}

	public static void main(String[] args) {
		// Create a circular linked list: 1 -> 3 -> 5 -> 7 -> 9 -> 1 (circular)
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(7);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = head; // Make it circular

		// Value to search for
		int target = 5;

		// Perform search
		boolean result = search(head, target);

		// Output the result
		if (result) {
			System.out.println("Element " + target + " found in the circular linked list.");
		} else {
			System.out.println("Element " + target + " not found in the circular linked list.");
		}
	}
}
