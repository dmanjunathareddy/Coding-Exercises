package com.softgroup.dsa.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false; // If the list is empty or has only one node, there's no cycle.
		}

		ListNode slow = head; // Slow pointer moves one step at a time.
		ListNode fast = head; // Fast pointer moves two steps at a time.

		while (fast != null && fast.next != null) {
			slow = slow.next; // Move slow pointer one step.
			fast = fast.next.next; // Move fast pointer two steps.

			// If there is a cycle, the slow and fast pointers will meet.
			if (slow == fast) {
				return true;
			}
		}

		// If the fast pointer reaches the end of the list, there is no cycle.
		return false;
	}

	public static void main(String[] args) {
		LinkedListCycle solution = new LinkedListCycle();

		// Example usage:
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);

		// Creating a cycle for demonstration purposes:
		head.next.next.next.next = head.next;

		boolean hasCycle = solution.hasCycle(head);
		System.out.println("Does the linked list have a cycle? " + hasCycle); // Output: true
	}
}
