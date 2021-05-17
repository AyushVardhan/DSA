package com.twopointers.leetcode;

public class ListNodePartition {
    public static void main(String[] args) {
        RemoveNthFromEnd.ListNode head = new RemoveNthFromEnd.ListNode(1);
        head.next = new RemoveNthFromEnd.ListNode(4);
        head.next.next = new RemoveNthFromEnd.ListNode(3);
        head.next.next.next = new RemoveNthFromEnd.ListNode(2);
        head.next.next.next.next = new RemoveNthFromEnd.ListNode(5);
        head.next.next.next.next.next = new RemoveNthFromEnd.ListNode(2);

        RemoveNthFromEnd.ListNode x = partition(head, 3);
        System.out.println(x);
    }

    private static RemoveNthFromEnd.ListNode partition(RemoveNthFromEnd.ListNode head, int x) {
        RemoveNthFromEnd.ListNode left = new RemoveNthFromEnd.ListNode(-101),
                right = new RemoveNthFromEnd.ListNode(-101);
        RemoveNthFromEnd.ListNode tmp = head;
        RemoveNthFromEnd.ListNode st = left, end = right;

        while (tmp != null) {
            if (tmp.val < x) {
                left.next = new RemoveNthFromEnd.ListNode(tmp.val);
                left = left.next;
            } else {
                right.next = new RemoveNthFromEnd.ListNode(tmp.val);
                right = right.next;
            }
            tmp = tmp.next;
        }

        left.next = end.next;
        return st.next;
    }
}
