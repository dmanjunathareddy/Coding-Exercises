package com.softgroup.dsa.search;

public class MergeSortedLinkedLists {

	// Function to merge two sorted linked lists
	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		// Append remaining nodes from either list
		if (l1 != null) {
			current.next = l1;
		} else {
			current.next = l2;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// Create two sample sorted linked lists
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);

		// Merge the two lists
		ListNode mergedList = merge(l1, l2);

		// Output the merged list
		while (mergedList != null) {
			System.out.print(mergedList.val + " ");
			mergedList = mergedList.next;
		}
	}
}
