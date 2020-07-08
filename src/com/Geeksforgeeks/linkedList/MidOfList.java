package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class MidOfList {
    Node head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int n = in.nextInt();
            Node head = new Node(in.nextInt(),null);
            MidOfList list = new MidOfList();
            list.addNode(head);
            for (int i = 1; i < n; i++){
                list.addNode(new Node(in.nextInt(),null));
            }

            System.out.println(list.getMid(list.head));
        }
    }

    private int getMid(Node head) {
        if (head==null)
            return -1;

        Node slow = head, fast = head;

        if (fast.next==null)
            return slow.data;

        if (fast.next.next==null)
            return slow.next.data;

        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next==null){
            return slow.data;
        }else {
            return slow.next.data;
        }
     }

    private void addNode(Node node) {
        if (head==null){
            head = node;
        }else {
            Node tmp = head;
            while (tmp.next!=null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
}
