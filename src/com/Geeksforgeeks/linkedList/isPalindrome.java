package com.Geeksforgeeks.linkedList;

import java.util.Scanner;
import java.util.Stack;

public class isPalindrome {
    Node head;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            //int k = sc.nextInt();
            isPalindrome llist = new isPalindrome();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1, null);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a, null));
            }

            isPalindrome g = new isPalindrome();
            if (g.isPalindromeCheck(llist.head))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }

    }

    private boolean isPalindromeCheck(Node head) {
        Node slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null)
            stack.push(slow.data);

        slow = slow.next;
        while (slow != null) {
            if (slow.data != stack.pop())
                return false;
            slow = slow.next;
        }

        return true;
    }
}
