package com.linkedList;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateUnsortedList {
    Node head;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
       
        
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            RemoveDuplicateUnsortedList llist = new RemoveDuplicateUnsortedList();
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a, null));
            }
            //llist.printList();	
            RemoveDuplicateUnsortedList g = new RemoveDuplicateUnsortedList();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }

    private Node removeDuplicates(Node head) {
        Node tmp = head, prev = null;

        Set<Integer> set = new HashSet<>();
        while (tmp != null) {
            if (set.contains(tmp.data)) {
                if (tmp.next != null)
                    prev.next = tmp.next;
                else prev.next = null;
            } else {
                set.add(tmp.data);
                prev = tmp;
            }
            tmp = tmp.next;
        }

        return head;
    }
}
