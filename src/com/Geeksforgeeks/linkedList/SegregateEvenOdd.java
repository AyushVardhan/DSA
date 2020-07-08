package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class SegregateEvenOdd {
    Node head;

    private void addNode(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();

            Node head = new Node(in.nextInt(), null);
            SegregateEvenOdd list = new SegregateEvenOdd();
            list.addNode(head);
            for (int i = 1; i < n; i++) {
                list.addNode(new Node(in.nextInt(), null));
            }

            list.segregateEvenOdd(list.head);
            System.out.println();
        }
    }

    private void segregateEvenOdd(Node head) {
        if (head == null)
            return;

        Node tmp = head, oddFirst = null, evenFirst = null, odd = null, even = null;
        while (true) {

            if (tmp == null) {
                if (even != null)
                    even.next = oddFirst;
                else
                    evenFirst = oddFirst;

                if (odd != null)
                    odd.next = null;

                break;
            }

            if (tmp.data % 2 != 0) {
                if (oddFirst == null) {
                    oddFirst = tmp;
                    odd = oddFirst;
                } else {
                    odd.next = tmp;
                    odd = tmp;
                }
            } else {
                if (evenFirst == null) {
                    evenFirst = tmp;
                    even = evenFirst;
                } else {
                    even.next = tmp;
                    even = tmp;
                }
            }

            tmp = tmp.next;
        }

        while (evenFirst != null) {
            System.out.print(evenFirst.data + " ");
            evenFirst = evenFirst.next;
        }
    }
}
