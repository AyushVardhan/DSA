package com.Geeksforgeeks.linkedList;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter length of 1st List : ");
        int n1 = in.nextInt();

        System.out.println();
        System.out.print("Enter length of 2nd List : ");
        int n2 = in.nextInt();

        Node listOne, listTwo, headOne, headTwo;
        MergeSort ms = new MergeSort();

        System.out.println("Enter " + n1 + " items: ");
        listOne = new Node(in.nextInt(), null);
        headOne = listOne;
        for (int i = 2; i <= n1; i++) {
            listOne.next = new Node(in.nextInt(), null);
            listOne = listOne.next;
        }

        System.out.println();

        System.out.println("Enter " + n2 + " items: ");
        listTwo = new Node(in.nextInt(), null);
        headTwo = listTwo;
        for (int i = 2; i <= n2; i++) {
            listTwo.next = new Node(in.nextInt(), null);
            listTwo = listTwo.next;
        }

        Node node = mergeLists(headOne, headTwo);
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private static Node mergeLists(Node headOne, Node headTwo) {
        if (headOne == null)
            return headTwo;

        if (headTwo == null)
            return headOne;

        Node result;
        if (headOne.data < headTwo.data) {
            result = headOne;
            result.next = mergeLists(headOne.next, headTwo);
        } else {
            result = headTwo;
            result.next = mergeLists(headOne, headTwo.next);
        }

        return result;
    }
}
