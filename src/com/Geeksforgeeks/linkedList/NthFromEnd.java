package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class NthFromEnd {
    Node head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0){
            int n = in.nextInt();
            int k = in.nextInt();

            NthFromEnd list = new NthFromEnd();
            list.addNode(new Node(in.nextInt(),null));
            for (int i = 1; i < n; i++){
                list.addNode(new Node(in.nextInt(),null));
            }

            System.out.println(list.getNthFromEnd(list.head,k));;
        }
    }

    private int getNthFromEnd(Node head, int k) {
        Node start=head,end=head;
        for (int i = 2; i <= k; i++){
            if (end.next!=null){
                end = end.next;
            }else return -1;
        }

        while (end.next!=null){
            start = start.next;
            end = end.next;
        }

        return start.data;
    }

    private void addNode(Node node) {
        if (head==null)
            head = node;
        else {
            Node tmp = head;
            while (tmp.next!=null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
}
