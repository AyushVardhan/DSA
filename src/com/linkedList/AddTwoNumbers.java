package com.linkedList;

import java.util.Scanner;

public class AddTwoNumbers {
    Node head;

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        // System.out.println("");
    }

    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data, null);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n1 = sc.nextInt();
            AddTwoNumbers list1 = new AddTwoNumbers();
            for (int i = 1; i <= n1; i++) {
                int a = sc.nextInt();
                list1.push(a);
            }
            int n2 = sc.nextInt();
            AddTwoNumbers list2 = new AddTwoNumbers();
            for (int i = 0; i < n2; i++) {
                int b = sc.nextInt();
                list2.push(b);
            }
            AddTwoNumbers list3 = new AddTwoNumbers();
            AddTwoNumbers g = new AddTwoNumbers();
            Node rs = g.addTwoLists(list1.head, list2.head);
            list3.printList(rs);
            System.out.println();
            T--;
        }
    }

    private Node addTwoLists(Node first, Node second) {
        Node start = new Node(-1, null);
        Node tmp = start;
        int n1, n2, flag = 0;

        while (first != null || second != null) {

            if (first != null) {
                n1 = first.data;
                first = first.next;
            } else
                n1 = 0;

            if (second != null) {
                n2 = second.data;
                second = second.next;
            } else
                n2 = 0;

            int sum = flag + n1 + n2;
            tmp.next = new Node(sum % 10, null);
            tmp = tmp.next;
            if (sum >= 10) {
                flag = sum / 10;
            } else {
                flag = 0;
            }

            if (first == null && second == null && flag != 0) {
                tmp.next = new Node(flag, null);
                tmp = tmp.next;
            }
        }

        return start.next;
    }
}


/*
        long num1 = 0, num2 = 0, rev1 = 0, rev2 = 0;
        while (first != null) {
            num1 = num1 * 10 + first.data;
            first = first.next;
        }

        while (second != null) {
            num2 = num2 * 10 + second.data;
            second = second.next;
        }

        while (num1 != 0) {
            long r = num1 % 10;
            rev1 = rev1 * 10 + r;
            num1 = num1 / 10;
        }

        while (num2 != 0) {
            long r = num2 % 10;
            rev2 = rev2 * 10 + r;
            num2 = num2 / 10;
        }

        long tmp = rev1 + rev2;
        Node start = new Node(-1, null);
        Node tmp1 = start;

        while (tmp != 0) {
            tmp1.next = new Node((int) (tmp % 10), null);
            tmp1 = tmp1.next;
            tmp = tmp / 10;
        }
        return start.next;
 */