package com.linkedList;

import java.util.Scanner;

class FlatNode {
    int data;
    FlatNode next;
    FlatNode bottom;

    FlatNode(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlatteningALinkedList {
    FlatNode head;

    void printList(FlatNode node) {
        //Node temp = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        FlatteningALinkedList list = new FlatteningALinkedList();
        while (t > 0) {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = sc.nextInt();

            FlatNode temp = null;
            FlatNode tempB = null;
            FlatNode pre = null;
            FlatNode preB = null;
            int flag = 1;
            int flag1 = 1;
            for (int i = 0; i < N; i++) {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new FlatNode(a1);
                if (flag == 1) {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                } else {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for (int j = 0; j < m; j++) {
                    int a = sc.nextInt();
                    tempB = new FlatNode(a);
                    if (flag1 == 1) {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    } else {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            FlatteningALinkedList g = new FlatteningALinkedList();
            FlatNode root = flatten(list.head);
            list.printList(root);

            t--;
        }
    }

    private static FlatNode flatten(FlatNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return merge(head, flatten(head.next));
    }

    private static FlatNode merge(FlatNode a, FlatNode b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        FlatNode result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        return result;
    }
}
