package com.linkedList;

import java.util.Scanner;

public class MultiplyLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Node head = null;
            Node phead = null;
            int n = sc.nextInt();
            while (n-- > 0) {
                int n1 = sc.nextInt();
                if (head == null)
                    head = new Node(n1, null);
                else {
                    addHead(head, n1);
                }
            }
            int m = sc.nextInt();
            while (m-- > 0) {
                int n1 = sc.nextInt();
                if (phead == null)
                    phead = new Node(n1, null);
                else {
                    addPhead(phead, n1);
                }
            }
            MultiplyLists g = new MultiplyLists();

            System.out.println(g.multiplyTwoLists(head, phead));
        }
    }

    private long multiplyTwoLists(Node l1, Node l2) {
        long MOD = 1000000007;

        long n1 = 0, n2 = 0;
        while (l1 != null) {
            n1 = ((n1 * 10) % MOD + (l1.data) % MOD) % MOD;
            l1 = l1.next;
        }

        while (l2 != null) {

            n2 = ((n2 * 10) % MOD + (l2.data) % MOD) % MOD;
            l2 = l2.next;
        }

        return (n1 % MOD * n2 % MOD) % MOD;
    }

    public static void addHead(Node node, int a) {
        if (node == null)
            return;
        if (node.next == null)
            node.next = new Node(a, null);
        else
            addHead(node.next, a);
    }

    public static void addPhead(Node node, int a) {
        if (node == null)
            return;
        if (node.next == null)
            node.next = new Node(a, null);
        else
            addPhead(node.next, a);
    }
}
