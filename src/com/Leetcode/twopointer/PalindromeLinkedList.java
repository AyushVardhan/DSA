package com.Leetcode.twopointer;

public class PalindromeLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode tmp = head;

        if (tmp.next == null)
            return true;

        if (tmp.next.next == null) {
            if (tmp.val == tmp.next.next.val) {
                return true;
            } else {
                return false;
            }
        }

        ListNode mid = tmp, fast = tmp.next.next;
        while (fast != null) {
            fast = fast.next;
            mid = mid.next;
        }

        ListNode prev = null;
        ListNode current = mid;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        mid = prev;

        while (mid != null) {
            if (tmp.val != mid.val)
                return false;

            mid = mid.next;
            tmp = tmp.next;
        }

        return true;
    }
}
