package com.programming.twopointers.leetcode;

public class RotateList {
    public static void main(String[] args) {
        RemoveNthFromEnd.ListNode head = new RemoveNthFromEnd.ListNode(1);
        head.next = new RemoveNthFromEnd.ListNode(2);
        head.next.next = new RemoveNthFromEnd.ListNode(3);
        head.next.next.next = new RemoveNthFromEnd.ListNode(4);
        head.next.next.next.next = new RemoveNthFromEnd.ListNode(5);

        RemoveNthFromEnd.ListNode x = rotateRight(head, 2);
        System.out.println(x);
    }

    private static RemoveNthFromEnd.ListNode rotateRight(RemoveNthFromEnd.ListNode head, int n) {
        if (head == null) return head;
        int length = 0;
        RemoveNthFromEnd.ListNode lenHead = head;
        while (lenHead!=null) {
            lenHead = lenHead.next;
            length++;
        }

        if (n >= length) {
            n = n % length;
        }

        if (n == 0)
            return head;

        RemoveNthFromEnd.ListNode tmp = new RemoveNthFromEnd.ListNode(-101);
        tmp.next = head;
        RemoveNthFromEnd.ListNode slow = tmp, fast = tmp;

        while (n > 0) {
            fast= fast.next;
            n--;
        }

        while (fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }

        RemoveNthFromEnd.ListNode newHead = slow.next;
        slow.next = null;
        fast.next = tmp.next;

        return newHead;
    }
}
