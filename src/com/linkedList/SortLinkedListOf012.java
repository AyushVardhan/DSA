package com.linkedList;

import java.util.Scanner;

public class SortLinkedListOf012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt(), null);
            Node tail = head;
            while (n-- > 1) {
                tail.next = new Node(sc.nextInt(), null);
                tail = tail.next;
            }

            head = new SortLinkedListOf012().segregate(head);
            printList(head);
            System.out.println();
        }
    }

    private Node segregate(Node head) {
        Node zeroD, zeroH, oneD, oneH, twoD, twoH, tmp = head, prep, res;

        zeroD = new Node(-1, null);
        zeroH = zeroD;
        oneD = new Node(-1, null);
        oneH = oneD;
        twoD = new Node(-1, null);
        twoH = twoD;

        while (tmp != null) {
            if (tmp.data == 0) {
                prep = new Node(tmp.data, null);
                zeroD.next = prep;
                zeroD = zeroD.next;
            } else if (tmp.data == 1) {
                prep = new Node(tmp.data, null);
                oneD.next = prep;
                oneD = oneD.next;
            } else {
                prep = new Node(tmp.data, null);
                twoD.next = prep;
                twoD = twoD.next;
            }
            tmp = tmp.next;
        }

        oneD.next = twoH.next;
        zeroD.next = oneH.next;

        res = zeroH.next;
        return res;
    }

    public static void printList(Node head) {
        if (head == null)
            return;

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
