package com.softgroup.dsa.search;

public class ReverseLinkedList {

    // Function to reverse a linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current; // Move pointers one position ahead
            current = nextTemp; // Move to the next node
        }

        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 3 -> 5 -> 7 -> 9 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        // Reverse the linked list
        ListNode newHead = reverse(head);

        // Output the reversed list
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
