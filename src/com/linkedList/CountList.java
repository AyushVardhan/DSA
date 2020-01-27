package com.linkedList;

import java.util.Scanner;

class NodeCount{
    int data;
    NodeCount next;

    NodeCount(int d, NodeCount n){
        data = d;
        next = n;
    }
}

public class CountList {
    NodeCount head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0){
            int n = in.nextInt();
            NodeCount head = new NodeCount(in.nextInt(),null);
            CountList list = new CountList();
            list.addNode(head);
            for (int i = 1; i < n; i++){
                list.addNode(new NodeCount(in.nextInt(),null));
            }
            System.out.println(list.getCount(list.head));;
        }
    }

    private int getCount(NodeCount head) {
        if (head ==null){
            return 0;
        }else {
            int count = 1;
            NodeCount tmp = head;
            while (tmp.next!=null){
                tmp = tmp.next;
                count++;
            }
            return count;
        }
    }

    private void addNode(NodeCount node) {
        if (head==null){
            head = node;
        }else {
            NodeCount temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }

            temp.next = node;
        }
    }
}
