package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class PairwiseSwap {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);

            addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a, null));
            }


            PairwiseSwap gfg = new PairwiseSwap();
            head = gfg.pairwiseSwap(head);
            printList(head);
            System.out.println();
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private Node pairwiseSwap(Node head) {
        if (head == null)
            return null;

        Node n1 = head;
        Node n2 = head.next;

        while (n2 != null && n2.next != null) {
            int tmp = n1.data;
            n1.data = n2.data;
            n2.data = tmp;

            n1 = n2.next;
            n2 = n2.next.next;
        }

        if (n2 != null) {
            int tmp = n1.data;
            n1.data = n2.data;
            n2.data = tmp;
        }

        return head;
    }
}