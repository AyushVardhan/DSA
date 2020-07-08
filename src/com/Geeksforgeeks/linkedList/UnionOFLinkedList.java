package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class UnionOFLinkedList {
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
            UnionOFLinkedList llist1 = new UnionOFLinkedList();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist1.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new Node(a, null));
            }
            llist1.head = head;
            n = sc.nextInt();
            a1 = sc.nextInt();
            UnionOFLinkedList llist2 = new UnionOFLinkedList();
            Node head2 = new Node(a1, null);
            llist2.addToTheLast(head2);
            llist2.head = head2;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist2.addToTheLast(new Node(a, null));
            }
            UnionOFLinkedList obj = new UnionOFLinkedList();
            Node start = obj.findUnion(llist1.head, llist2.head);
            llist1.printList(start);
        }
    }

    Node findUnion(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node t1 = mergeSort(head1);
        Node t2 = mergeSort(head2);

        Node first = null, result = null;
        int temp = 0;
        while (t1 != null || t2 != null) {
            if (t1 == null) {
                temp = t2.data;
                t2 = t2.next;
            } else if (t2 == null) {
                temp = t1.data;
                t1 = t1.next;
            } else {
                if (t1.data == t2.data) {
                    temp = t1.data;
                } else if (t1.data < t2.data) {
                    temp = t1.data;
                } else {
                    temp = t2.data;
                }
                while (t1 != null && temp == t1.data) t1 = t1.next;
                while (t2 != null && temp == t2.data) t2 = t2.next;
            }

            if (result == null) {
                result = new Node(temp, null);
                first = result;
            } else {
                result.next = new Node(temp, null);
                result = result.next;
            }
        }
        return first;
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node first = head, second = splitHalf(head);

        first = mergeSort(first);
        second = mergeSort(second);

        Node result = sortedMerge(first, second);
        return result;
    }

    private static Node sortedMerge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        Node result;

        if (first.data <= second.data) {
            result = new Node(first.data, null);
            result.next = sortedMerge(first.next, second);
        } else {
            result = new Node(second.data, null);
            result.next = sortedMerge(first, second.next);
        }

        return result;
    }

    private static Node splitHalf(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        Node result = slow.next;
        slow.next = null;
        return result;

    }
}
