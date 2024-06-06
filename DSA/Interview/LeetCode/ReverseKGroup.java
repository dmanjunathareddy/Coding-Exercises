package com.softgroup.dsa.interview.leetcode;


public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to handle edge cases such as head change
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode curr = dummy, nex = dummy, pre = dummy;
        int count = 0;

        // Count the number of nodes in the list
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // Loop for each group
        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            // Move pre to the end of the reversed section
            pre = curr;
            count -= k;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example list: 1->2->3->4->5 and k=3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;

        ListNode result = reverseKGroup(head, k);

        // Print the result list
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.print("null");
    }
}
