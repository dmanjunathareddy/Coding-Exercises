package com.softgroup.dsa.queue;

public class LinkedListCycle {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;

			slow = slow.next;
			fast = fast.next.next;
		}

		return true;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;

		System.out.println("Linked List Cycle Detection: " + hasCycle(head));
	}
}
