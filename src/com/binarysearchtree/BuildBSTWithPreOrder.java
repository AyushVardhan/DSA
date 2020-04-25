package com.binarysearchtree;

import java.util.Scanner;

public class BuildBSTWithPreOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            idx = 0;
            int n = in.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Node root = buildTree(arr, n);
            printInorder(root);
            System.out.println();
        }
    }

    static int idx = 0;

    private static Node buildTree(int[] arr, int n) {
        return util(arr, arr[0], Integer.MIN_VALUE, Integer.MAX_VALUE, n);
    }

    private static Node util(int[] arr, int key, int minValue, int maxValue, int n) {

        if (idx >= n)
            return null;

        Node root = null;

        if (key > minValue && key < maxValue) {
            root = new Node(arr[idx]);
            idx = idx + 1;

            if (idx < n) {
                root.left = util(arr, arr[idx], minValue, key, n);
                root.right = util(arr, arr[idx], key, maxValue, n);
            }
        }

        return root;
    }

    static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
