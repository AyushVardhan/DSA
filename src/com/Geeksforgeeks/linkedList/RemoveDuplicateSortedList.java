package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class RemoveDuplicateSortedList {
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

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            RemoveDuplicateSortedList llist = new RemoveDuplicateSortedList();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a, null));
            }

            RemoveDuplicateSortedList g = new RemoveDuplicateSortedList();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }

    private Node removeDuplicates(Node root) {
        Node head = root, tmp;

        while (root != null) {
            if (root.next != null && root.data == root.next.data) {
                tmp = root;
                while (tmp.data == tmp.next.data) {
                    tmp = tmp.next;
                    if (tmp.next == null)
                        break;
                }
                root.next = tmp.next;
                root = root.next;
                continue;
            }
            root = root.next;
        }

        return head;
    }
}
