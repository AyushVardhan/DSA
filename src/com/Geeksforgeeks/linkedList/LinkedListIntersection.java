package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class LinkedListIntersection {
    static Node append(Node head, int data)
    {
        if(head == null)
            return new Node(data, null);

        head.next = append(head.next, data);
        return head;

    }
    static void printList(Node node)
    {
        if(node == null)
            System.out.print("");
        else{
            while(node != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }

    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();

        while(t-- > 0)
        {
            Node head1 = null;
            Node head2 = null;

            int temp = 0;
            int n1 = sc.nextInt();

            for(int i = 0; i < n1; i++)
            {
                temp = sc.nextInt();

                if(head1 == null)
                    head1 = new Node(temp, null);
                else head1 = append(head1, temp);
            }

            int n2 = sc.nextInt();
            for(int i = 0; i < n2; i++)
            {
                temp = sc.nextInt();

                if(head2 == null)
                    head2 = new Node(temp, null);
                else head2 = append(head2, temp);
            }

            Node result = findIntersection(head1, head2);

            printList(result);
            System.out.println();


        }
    }

    static Node findIntersection(Node head1, Node head2)
    {
        if(head1 == null || head2 == null) return null;
        Node t1 = mergeSort(head1);
        Node t2 = mergeSort(head2);
        /*printList(t1);
        printList(t2);*/
        Node first = null, result = null;

        while(t1 != null && t2 != null) {
            if(t1.data < t2.data) {
                t1 = t1.next;
            } else if(t1.data > t2.data) {
                t2 = t2.next;
            } else {
                //System.out.print(t1.data + " ");
                if(result == null) {
                    result = new Node(t1.data,null);
                    first = result;
                } else {
                    //System.out.print(t1.data + " ");
                    result.next = new Node(t1.data,null);
                    result = result.next;
                }
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return first;
    }

    private static Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;

        Node first = head, second = splitHalf(head);
        /*printList(first);
        printList(second);
        */
        first = mergeSort(first);
        second = mergeSort(second);

        Node result = sortedMerge(first, second);
        //printList(result);
        //System.out.println("------------");
        return result;
    }

    private static Node sortedMerge(Node first, Node second) {
        Node result = null;

        if(first == null) return second;
        if(second == null) return first;

        /*printList(first);
        printList(second);*/
        if(first.data <= second.data) {
            result = first;
            result.next = sortedMerge(first.next, second);
        } else {
            result = second;
            result.next = sortedMerge(first, second.next);
        }

        return result;

    }

    private static Node splitHalf(Node head) {
        Node fast = null, slow = null;
        if(head == null || head.next == null) {
            return null;
        } else {
            slow = head;
            fast = head.next;
            while(fast != null) {
                fast = fast.next;
                if(fast != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            Node result = slow.next;
            slow.next = null;
            return result;
        }
    }
}
