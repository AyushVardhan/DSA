package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class RearrangeLinkedList {
    Node head;

    public void addToTheLast(Node node) {

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

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {

        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt()) {
            int n = sc.nextInt();
            RearrangeLinkedList list = new RearrangeLinkedList();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            list.addToTheLast(head);

            for (int i = 1; i < n && sc.hasNextInt(); i++) {
                int a = sc.nextInt();
                list.addToTheLast(new Node(a, null));
            }


            Node x = RearrangeLinkedList.rearrange(head);
            list.printList(x);
            t--;
        }
    }

    private static Node rearrange(Node head) {

        if (head == null || head.next == null)
            return head;

        Node oddFirst = head;
        Node evenFirst = head.next;
        Node odd = oddFirst, even = evenFirst;

        while (true) {

            if (even.next == null) {
                odd.next = evenFirst;
                break;
            }

            odd.next = even.next;
            odd = even.next;

            if (odd.next==null) {
                even.next = null;
                odd.next = evenFirst;
                break;
            }

            even.next = odd.next;
            even = odd.next;
        }

        return oddFirst;
    }
}
