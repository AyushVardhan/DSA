package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class ReverseLinkedListInGroup {
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

            int k = sc.nextInt();
            ReverseLinkedListInGroup gfg = new ReverseLinkedListInGroup();
            Node res = gfg.reverse(head, k);
            printList(res);
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

    public static Node reverse(Node node, int k) {
        Node curr = node, prev = null, next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null)
            node.next = reverse(next, k);
        return prev;
    }


//    Below is my solution: [Iterative One]
//    private Node reverse(Node head, int k) {
//        int count = 1;
//
//        Node curr = head, prev = null, last = null, prevHead = null, startAt = null;
//        while (curr != null) {
//            if (count <= k) {
//                last = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = last;
//
//                if (last == null && prevHead != null) {
//                    prevHead.next = prev;
//                }
//
//                if (last == null && prevHead == null)
//                    head = prev;
//
//                if (count == 1)
//                    startAt = prev;
//            }
//
//            if (count == k) {
//                count = 1;
//                if (prevHead == null) {
//                    prevHead = head;
//                    head = prev;
//                } else {
//                    prevHead.next = prev;
//                    prevHead = startAt;
//                }
//
//                prev = null;
//                last = null;
//                continue;
//            }
//
//            count++;
//        }
//
//        return head;
//    }

}
