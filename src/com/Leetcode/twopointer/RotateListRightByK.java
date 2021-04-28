package com.Leetcode.twopointer;

public class RotateListRightByK {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode res = rotateListRightByK(head,6);
        System.out.println(res);
    }

    private static ListNode rotateListRightByK(ListNode head, int n) {
        int len = getLen(head);
        if (n >= len)
            n = n % len;

        if (n == 0)
            return head;

        ListNode first = head;
        ListNode second = head;

        for (int i = 1; i < n+1; i++) {
            first = first.next;
        }

        while (first.next!=null) {
            first = first.next;
            second = second.next;
        }

        ListNode tmp = second.next;
        ListNode res = tmp;
        second.next = null;

        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = head;
        return res;
    }

    private static int getLen(ListNode head) {
        ListNode tmp = head;
        int cnt = 0;
        while (tmp!=null){
            tmp = tmp.next;
            cnt++;
        }
        return cnt;
    }
}
