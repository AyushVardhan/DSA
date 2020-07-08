package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class AddOneToLinkedList {
    static Node head;

    public static void insert(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("1");
                continue;
            }

            head = null;
            while (n > 0) {
                insert(new Node(n % 10, null));
                n /= 10;
            }
            AddOneToLinkedList g = new AddOneToLinkedList();
            Node mnode = g.addOne(head);
            print(mnode);
            System.out.println();
        }
    }

    private Node addOne(Node head) {
        Node start = new Node(-1, null);
        Node tmp = start;
        int n1, flag = 0, addFlag = 0;
        int sum = 0;

        while (head != null) {

            n1 = head.data;
            head = head.next;

            if (addFlag == 0) {
                addFlag = 1;
                sum = flag + n1 + 1;
            } else {
                sum = flag + n1;
            }

            tmp.next = new Node(sum % 10, null);
            tmp = tmp.next;
            if (sum >= 10) {
                flag = sum / 10;
            }else {
                flag = 0;
            }

            if (head == null && flag != 0) {
                tmp.next = new Node(flag, null);
                tmp = tmp.next;
            }
        }

        Node curr = start.next, prev = null, last = null;

        while (curr != null) {
            last = curr.next;
            curr.next = prev;
            prev = curr;
            curr = last;
        }

        return prev;
    }

    public static void print(Node mnode) {
        while (mnode != null) {
            System.out.print(mnode.data);
            mnode = mnode.next;
        }
    }
}
