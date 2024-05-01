package com.softgroup.dsa.array;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			ListNode nextTemp = current.next;
			current.next = prev;
			prev = current;
			current = nextTemp;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ReverseLinkedList solution = new ReverseLinkedList();
		ListNode reversedList = solution.reverseList(head);

		// Print the reversed list
		while (reversedList != null) {
			System.out.print(reversedList.val + " ");
			reversedList = reversedList.next;
		}
	}
}
