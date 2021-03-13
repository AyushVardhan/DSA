package com.educative;

import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        // TODO: Write your code here

        ListNode headCopy = head, prevOfStart = null, start = null, end = null, nextToEnd = null;
        int cnt = 0;

        while (headCopy!=null && cnt < p) {
            cnt++;
            if (cnt == p-1) {
                prevOfStart = headCopy;
                break;
            }
            headCopy = headCopy.next;
        }

        start = prevOfStart == null ? head : prevOfStart.next;
        headCopy = start;
        cnt = 0;
        int length = q - p + 1;

        while (headCopy!=null) {
            cnt++;
            if (cnt == length) {
                end = headCopy;
                break;
            }
            headCopy = headCopy.next;
        }

        nextToEnd = end == null ? null : end.next;

        ListNode prev = null, next = null, curr = start;

        cnt = 1;
        while (cnt <= length) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }
        prevOfStart.next = prev;

        while (prev != start) {
            prev = prev.next;
        }

        prev.next = nextToEnd;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}