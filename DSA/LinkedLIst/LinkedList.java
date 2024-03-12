package com.softgroup.dsa.linkedlist;



public class LinkedList {
	Node head;

	public void swapNodes(int x, int y) {
		if (x == y)
			return;

		Node prevX = null, currX = head;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}

		Node prevY = null, currY = head;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		if (currX == null || currY == null)
			return;

		// If x is not the head of the linked list
		if (prevX != null)
			prevX.next = currY;
		else // Make y the new head
			head = currY;

		// If y is not the head of the linked list
		if (prevY != null)
			prevY.next = currX;
		else // Make x the new head
			head = currX;

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}

	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.push(7);
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		System.out.println("Linked list before swapping:");
		list.printList();

		list.swapNodes(4, 6);

		System.out.println("Linked list after swapping:");
		list.printList();
	}
}
