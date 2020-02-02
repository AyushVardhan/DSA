package com.linkedList;

import java.util.HashMap;
import java.util.Scanner;

public class IntersectionInYShaped {
    Node head = null;
    Node tail = null;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            //Node temp = head;
            //while (temp.next != null)
            //temp = temp.next;

            //temp.next = node;
            tail.next = node;
            tail = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Driver program to test above functions */
    public static void main(String args[]) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            IntersectionInYShaped llist1 = new IntersectionInYShaped();
            IntersectionInYShaped llist2 = new IntersectionInYShaped();
            IntersectionInYShaped llist3 = new IntersectionInYShaped();

            int a1 = sc.nextInt();
            Node head1 = new Node(a1, null);
            Node tail1 = head1;
            llist1.addToTheLast(head1);
            for (int i = 1; i < n1; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new Node(a, null));
            }


            int b1 = sc.nextInt();
            Node head2 = new Node(b1, null);
            Node tail2 = head2;
            llist2.addToTheLast(head2);
            for (int i = 1; i < n2; i++) {
                int b = sc.nextInt();
                llist2.addToTheLast(new Node(b, null));
            }

            int c1 = sc.nextInt();
            Node head3 = new Node(c1, null);
            Node tail3 = head3;
            llist3.addToTheLast(head3);
            for (int i = 1; i < n3; i++) {
                int c = sc.nextInt();
                llist3.addToTheLast(new Node(c, null));
            }

            if (tail1 != null)
                tail1.next = head3;
            if (tail2 != null)
                tail2.next = head3;

            IntersectionInYShaped obj = new IntersectionInYShaped();
            System.out.println(obj.intersectPoint(llist1.head, llist2.head));
            t--;
        }
    }

    private int intersectPoint(Node headA, Node headB) {
        int res = -1;

        Node node1 = headA, node2 = headB;
        HashMap<Node, Integer> map = new HashMap<>();

        while (node1 != null) {
            map.put(node1.next, node1.data);
            node1 = node1.next;
        }

        while (node2 != null) {
            if (map.containsKey(node2.next)) {
                res = node2.next.data;
                break;
            }
            node2 = node2.next;
        }

        return res;
    }
}
