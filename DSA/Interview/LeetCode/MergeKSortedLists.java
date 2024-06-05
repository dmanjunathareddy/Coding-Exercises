package com.softgroup.dsa.interview.leetcode;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Define a comparator for the priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Create a dummy head for the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            // Get the smallest node from the priority queue
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            // Add the next node of the same list to the priority queue
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example input: [[1->4->5], [1->3->4], [2->6]]
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode result = mergeKLists(lists);

        // Print the merged list
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.print("null");
    }
}
