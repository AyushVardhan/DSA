package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class ReorderList {
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

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a, null));
            }

            llist.head = llist.reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }

    private Node reorderlist(Node head) {
        Node tmp = head, fHalf = null, lHalf;
        int length = 1;

        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }

        int count_1st = (length % 2 == 0) ? length >> 1 : (length >> 1) + 1;

        tmp = head;
        fHalf = head;
        Node itr = fHalf;
        for (int i = 1; i < count_1st; i++) {
            tmp = tmp.next;
            itr.next = tmp;
            itr = itr.next;
        }

        lHalf = itr.next;
        itr.next = null;

        Node prevNode = null;
        Node currNode = lHalf;
        Node lastNode = null;

        while (currNode != null) {
            lastNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = lastNode;
        }

        lHalf = prevNode;

        head = new Node(0,null);
        Node curr = head;
        while (fHalf != null || lHalf != null) {
            if (fHalf != null) {
                curr.next = fHalf;
                fHalf = fHalf.next;
                curr = curr.next;
            }
            if (lHalf != null) {
                curr.next = lHalf;
                lHalf = lHalf.next;
                curr = curr.next;
            }
        }

        head = head.next;
        return head;
    }
}