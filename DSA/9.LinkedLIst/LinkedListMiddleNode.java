package com.softgroup.dsa.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

public class LinkedListMiddleNode {
	public ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		// Move slow pointer one step at a time
		// Move fast pointer two steps at a time
		// When fast reaches the end, slow will be at the middle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		// Example usage
		LinkedListMiddleNode solution = new LinkedListMiddleNode();

		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		// Find the middle node
		ListNode middleNode = solution.findMiddle(head);

		if (middleNode != null) {
			System.out.println("Middle Node Value: " + middleNode.val); // Output: Middle Node Value: 3
		} else {
			System.out.println("The list is empty.");
		}
	}
}
