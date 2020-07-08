package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class InsertInSorted {
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
            InsertInSorted llist1 = new InsertInSorted();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist1.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new Node(a, null));
            }
            llist1.head = head;
            a1 = sc.nextInt();
            InsertInSorted obj = new InsertInSorted();
            Node start = obj.sortedInsert(llist1.head, a1);
            llist1.printList(start);
        }
    }

    private Node sortedInsert(Node head, int key) {
        Node prev = null, curr = head;
        while (curr != null) {

            if (key < curr.data && prev == null) {
                head = new Node(key, curr);
                break;
            } else if (key < curr.data) {
                Node node = new Node(key, curr);
                prev.next = node;
                break;
            }

            if (curr.next==null){
                Node node = new Node(key, null);
                curr.next = node;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}