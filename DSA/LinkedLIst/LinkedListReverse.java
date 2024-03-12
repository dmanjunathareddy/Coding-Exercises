package com.softgroup.dsa.linkedlist;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedListReverse {

	// Function to reverse a linked list
	public static Node reverseList(Node head) {
		Node prev = null;
		Node current = head;
		Node next;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		// The 'prev' now points to the new head of the reversed list
		return prev;
	}

	// Function to print a linked list
	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		System.out.println("Original linked list:");
		printList(head);

		// Reverse the linked list
		head = reverseList(head);

		System.out.println("Reversed linked list:");
		printList(head);
	}
}
