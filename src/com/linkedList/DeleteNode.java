package com.linkedList;

import java.util.Scanner;

public class DeleteNode {
    Node head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = in.nextInt();
            DeleteNode list = new DeleteNode();
            list.addNode(new Node(in.nextInt(), null));
            for (int i = 1; i < n; i++) {
                list.addNode(new Node(in.nextInt(), null));
            }

            int x = in.nextInt();
            System.out.println(list.deleteNthNode(list.head, x));
        }
    }

    private Node deleteNthNode(Node head, int x) {
        if (head == null)
            return null;

        Node prevNode, nextNode, currNode = head;
        if (currNode.next != null) {
            nextNode = currNode.next;
            if (x == 1) {
                return currNode.next;
            }
        } else return null;

        int count = 2;
        while (currNode.next != null) {
            prevNode = currNode;
            if (count == x) {
                prevNode.next = nextNode.next;
                break;
            }
            nextNode = nextNode.next;
            currNode = currNode.next;
            count++;
        }

        return head;
    }

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
}
