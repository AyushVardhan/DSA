package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class MergeTwoSortedLinkedList {
    Node head;

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


    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Driver program to test above functions */
    public static void main(String args[]) {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            MergeTwoSortedLinkedList llist1 = new MergeTwoSortedLinkedList();
            MergeTwoSortedLinkedList llist2 = new MergeTwoSortedLinkedList();

            int a1 = sc.nextInt();
            Node head1 = new Node(a1, null);
            llist1.addToTheLast(head1);
            if (sc.hasNextInt())
                for (int i = 1; i < n1; i++) {
                    //int a;

                    int a = sc.nextInt();
                    llist1.addToTheLast(new Node(a, null));
                }


            int b1 = sc.nextInt();
            Node head2 = new Node(b1, null);
            llist2.addToTheLast(head2);
            if (sc.hasNextInt())
                for (int i = 1; i < n2; i++) {
                    //int b;

                    int b = sc.nextInt();
                    llist2.addToTheLast(new Node(b, null));
                }
            llist1.head = new MergeTwoSortedLinkedList().sortedMerge(llist1.head, llist2.head);
            llist1.printList();

            t--;

        }
    }

    private Node sortedMerge(Node headA, Node headB) {
        if (headA == null)
            return headB;
        if (headB == null)
            return headA;

        Node res;
        if (headA.data < headB.data){
            res = headA;
            res.next = sortedMerge(headA.next,headB);
        }
        else {
            res = headB;
            res.next = sortedMerge(headA,headB.next);
        }

        return res;
    }
}
