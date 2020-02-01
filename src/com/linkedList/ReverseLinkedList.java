package com.linkedList;

import java.io.*;

public class ReverseLinkedList {
    Node head;  // head of lisl
    Node lastNode;
    static PrintWriter out;
    /* Linked list Node*/


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
        out.println();
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            ReverseLinkedList llist = new ReverseLinkedList();
            String nums[] = br.readLine().split(" ");
            if (n > 0) {
                int a1 = Integer.parseInt(nums[0]);
                Node head = new Node(a1, null);
                llist.addToTheLast(head);
            }
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(nums[i]);
                llist.addToTheLast(new Node(a, null));
            }


            llist.head = ReverseLinkedList.reverseList(llist.head);

            llist.printList();

            t--;
        }
        out.close();
    }

    static Node reverseList(Node head) {
        // add code here
        Node curr = head, prev = null, last = null;

        while (curr != null) {
            last = curr.next;
            curr.next = prev;
            prev = curr;
            curr = last;
        }

        return prev;
    }
}
