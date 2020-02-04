package com.linkedList;

import java.util.Scanner;

public class LengthOfLoop {
    Node head;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            LengthOfLoop llist1 = new LengthOfLoop();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist1.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new Node(a, null));
            }
            llist1.head = head;
            Node temp = null;
            Node te = null;
            int c = sc.nextInt();
            if (c > 0) {
                temp = head;
                te = head;
                while (te.next != null) te = te.next;
                while (c-- > 0) temp = temp.next;
                te.next = temp;
                // s->next=temp;
            }
            LengthOfLoop obj = new LengthOfLoop();
            System.out.println(obj.countNodesinLoop(llist1.head));
        }
    }

    private int countNodesinLoop(Node head) {
        if (head == null)
            return 0;
        Node slow = head.next, fast;
        if (slow != null && slow.next != null) {
            fast = head.next.next;
        } else
            return 0;

        while (slow != null && fast != null) {

            if (slow == fast) {
                int count = 1;
                slow = slow.next;
                while (slow != fast) {
                    count++;
                    slow = slow.next;
                }
                return count;
            }

            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return 0;
        }

        return 0;
    }
}
