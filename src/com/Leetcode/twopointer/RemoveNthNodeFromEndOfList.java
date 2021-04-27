package com.Leetcode.twopointer;

public class RemoveNthNodeFromEndOfList {

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

        ListNode res = removeNthFromEnd(head,2);
        System.out.println(res);
    }

     static ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0); //used to handle case for length 1
         dummy.next = head;
         ListNode first = dummy;
         ListNode second = dummy;

         for (int i = 1; i <= n+1; i++){
             first = first.next;
         }

         while(first != null) {
             first = first.next;
             second = second.next;
         }

         second.next = second.next.next;
         return dummy.next;
    }


}
