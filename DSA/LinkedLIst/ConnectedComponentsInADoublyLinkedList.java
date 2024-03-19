package com.softgroup.dsa.linkedlist;

class ListNode {
	int val;
	ListNode next, prev;

	ListNode(int val) {
		this.val = val;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedList {
	ListNode head, tail;

	DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	void insert(int val) {
		ListNode newNode = new ListNode(val);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
}

public class ConnectedComponentsInADoublyLinkedList {
	static int countConnectedComponents(DoublyLinkedList dll) {
		int connectedComponents = 0;
		ListNode current = dll.head;
		while (current != null) {
			if (current.prev == null || current.prev.next != current) {
				connectedComponents++;
			}
			current = current.next;
		}
		return connectedComponents;
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insert(1);
		dll.insert(2);
		dll.insert(3);
		dll.insert(4);
		dll.insert(5);
		dll.insert(6);
		dll.head.next.next.next = null; // Disconnecting sublist 1->2->3 from 4->5->6

		int connectedComponents = countConnectedComponents(dll);
		System.out.println("Number of connected components: " + connectedComponents);
	}
}
