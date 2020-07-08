package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class DeleteNNodesAfterMnodesInList {
    Node head;

    private void addNode(Node node) {
        if (null == head)
            head = node;
        else {
            Node tmp = head;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = node;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int len = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            DeleteNNodesAfterMnodesInList list = new DeleteNNodesAfterMnodesInList();
            list.addNode(new Node(in.nextInt(), null));
            for (int i = 1; i < len; i++) {
                list.addNode(new Node(in.nextInt(), null));
            }
            list.deleteCustom(list.head, m, n);
        }
    }

    private void deleteCustom(Node head, int M, int N) {
        Node tmp = head;
        int count_m = 1;

        if (tmp == null)
            return;

        while (tmp != null) {
            //System.out.print(tmp.data + " ");
            while (count_m < M && tmp.next != null) {
                count_m++;
                tmp = tmp.next;
                //System.out.print(tmp.data + " ");
            }

            //System.out.print(" -----TO DELETE----- ");

            int count_n = 1;
            Node delNode = tmp.next, prev = tmp;
            while (count_n <= N && delNode!=null) {
                count_n++;
                //System.out.print(delNode.data+" ");
                delNode = delNode.next;
            }

            count_m = 1;
            //System.out.println();
            prev.next = delNode;
            tmp = delNode;
        }

        //System.out.println(head);
    }
}
