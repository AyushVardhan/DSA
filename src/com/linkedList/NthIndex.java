package com.linkedList;

import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int d, Node n){
        data = d;
        next = n;
    }
}

public class NthIndex {
    Node head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0){
            int n = in.nextInt();
            int k = in.nextInt();

            Node head = new Node(in.nextInt(),null);
            NthIndex list = new NthIndex();
            list.addNode(head);
            for (int i = 1; i < n; i++){
                list.addNode(new Node(in.nextInt(),null));
            }

            System.out.println(list.getNth(list.head,k));;
        }
    }

    private int getNth(Node node, int ind) {
        if (node==null){
            return -1;
        }else {
            Node tmp = node, res=null;
            int count = 1;
            if (count==ind){
                res = tmp;
            }

            while (tmp.next !=null){
                tmp = tmp.next;
                count++;
                if (count==ind){
                    res = tmp;
                    break;
                }
            }
            return res.data;
        }
    }

    private void addNode(Node node) {
        if (head == null){
            head = node;
        }else {
            Node tmp = head;
            while (tmp.next !=null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
}
