package com.linkedList;

import java.util.Scanner;

public class DetectLoopInLinkedList {
    Node head; // head of list

    /* Linked list Node*/
    /* Inserts a new Node at front of the list. */
    public void push(int new_data) {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data, null);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        int t, d, n, i, x, c;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (d = 0; d < t; d++) {
            n = sc.nextInt();
            DetectLoopInLinkedList llist = new DetectLoopInLinkedList();
            Node q;
            for (i = 0; i < n; i++) {
                x = sc.nextInt();
                llist.push(x);
            }
            Node p;
            p = llist.head;
            q = llist.head;
            while (q.next != null) q = q.next;
            c = sc.nextInt();
            if (c > 0) {
                c = c - 1;
                for (i = 0; i < c; i++) {
                    p = p.next;
                }
                q.next = p;
            }
            if (new DetectLoopInLinkedList().detectLoop(llist.head) == 1)
                System.out.print("True\n");
            else
                System.out.print("False\n");
            // System.gc();
        }
    }

    private int detectLoop(Node head) {
        if (head == null)
            return 0;

        Node slow = head.next, fast = head.next.next;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return 0;

            if (slow == fast)
                return 1;
        }

        return 0;
    }
}
