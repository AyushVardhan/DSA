package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class RemoveKthNode {
    Node head;

    private void addNode(Node node) {
        if (null == head)
            head = node;
        else {
            Node tmp = head;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = node;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();
            RemoveKthNode list = new RemoveKthNode();
            list.addNode(new Node(in.nextInt(), null));
            for (int i = 1; i < n; i++) {
                list.addNode(new Node(in.nextInt(), null));
            }

            int x = in.nextInt();
            System.out.println(list.deleteEveryKthNode(list.head, x));
        }
    }

    private Node deleteEveryKthNode(Node head, int k) {
        Node tmp = head, prev = null;

        if (head == null) return null;
        if (k == 1) return null;

        int count = 1;
        while (tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
            count++;
            if (count == k) {
                if (tmp.next == null) {
                    prev.next = null;
                    return head;
                }
                prev.next = tmp.next;
                tmp = tmp.next;
                count = 1;
            }
        }

        return head;
    }
}
