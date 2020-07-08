package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class CheckIfCircularLinkedList {
    Node head;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            CheckIfCircularLinkedList list = new CheckIfCircularLinkedList();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                list.addToTheLast(new Node(a, null));
            }

            if (l == 1 && n >= 1) {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = head;
            }

            CheckIfCircularLinkedList g = new CheckIfCircularLinkedList();
            boolean b = g.isCircular(list.head);
            if (b == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    }

    private boolean isCircular(Node head) {
        if (head == null)
            return true;

        Node tmp = head.next;

        while (tmp != null && tmp != head) {
            tmp = tmp.next;
        }

        return (tmp == head);
    }
}
