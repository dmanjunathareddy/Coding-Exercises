package com.softgroup.dsa.search;

public class MiddleElementLinkedList {

    // Function to find the middle element of a linked list
    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move 'fast' pointer twice as fast as 'slow' pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // At this point, 'slow' pointer is at the middle or second middle element
        return slow;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 3 -> 5 -> 7 -> 9 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);

        // Find the middle element
        ListNode middle = findMiddle(head);

        if (middle != null) {
            System.out.println("Middle element: " + middle.val);
        } else {
            System.out.println("The linked list is empty.");
        }
    }
}
