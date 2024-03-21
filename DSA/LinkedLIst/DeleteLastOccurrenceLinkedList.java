package com.softgroup.dsa.linkedlist;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DeleteLastOccurrenceLinkedList {
    public ListNode deleteLastOccurrence(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = null;
        ListNode lastOccurrence = null;
        ListNode current = dummy;
        
        while (current != null) {
            if (current.val == target) {
                prev = lastOccurrence;
                lastOccurrence = current;
            }
            current = current.next;
        }
        
        if (lastOccurrence != null) {
            if (prev == null) {
                head = head.next;
            } else {
                // Traverse until the next occurrence of target value
                ListNode nextNode = lastOccurrence.next;
                while (nextNode != null && nextNode.val == target) {
                    prev = lastOccurrence;
                    lastOccurrence = nextNode;
                    nextNode = nextNode.next;
                }
                prev.next = lastOccurrence.next;
            }
        }
        
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(4);

        DeleteLastOccurrenceLinkedList list = new DeleteLastOccurrenceLinkedList();
        System.out.println("Original list:");
        printList(head);

        int target = 2; // Value to delete
        head = list.deleteLastOccurrence(head, target);

        System.out.println("List after deleting last occurrence of " + target + ":");
        printList(head);
    }
}
