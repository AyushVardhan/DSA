package com.linkedList;

import java.util.Scanner;

class Node1 {
    int data;
    Node1 next;

    Node1(int d, Node1 n) {
        data = d;
        next = n;
    }
}

public class printLinkedList {
    Node1 head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0) {
            int n = in.nextInt();
            Node1 head = new Node1(in.nextInt(), null);
            printLinkedList list = new printLinkedList();
            list.addNode(head);
            for (int i = 1; i < n; i++) {
                list.addNode(new Node1(in.nextInt(), null));
            }

            list.printList(list.head);
            System.out.println();
        }
    }

    private void printList(Node1 head) {
        Node1 temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

    private void addNode(Node1 node) {
        if (head == null) {
            head = node;
        } else {
            Node1 temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}
