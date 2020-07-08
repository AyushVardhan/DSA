package com.Geeksforgeeks.binarysearchtree;

import java.util.Scanner;

public class CountNodesInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            Node root = null;
            int sizeOfArray = sc.nextInt();
            int arr[] = new int[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                int x = sc.nextInt();
                arr[i] = x;
            }

            for (int i = 0; i < sizeOfArray; i++) {
                root = Geeks.newNode(root, arr[i]);
            }
            int l, h;
            l = sc.nextInt();
            h = sc.nextInt();
            System.out.println(Geeks.getCountOfNode(root, l, h));

        }
    }
}

class Geeks {
    public static Node createNewNode(int value) {
        Node temp = new Node(value);

        return temp;
    }

    static public Node newNode(Node root, int data) {
        if (root == null)
            root = createNewNode(data);
        else if (data < root.data)
            root.left = newNode(root.left, data);
        else
            root.right = newNode(root.right, data);

        return root;
    }

    public static int getCountOfNode(Node root, int l, int h) {
        // base case
        if (root == null)
            return 0;

        return total(root, l, h);
    }

    private static int total(Node root, int l, int h) {
        if (root == null)
            return 0;

        int count = 0;

        if (root.data >= l && root.data <= h) {
            count = 1;
        }

        return count + total(root.left, l, h) + total(root.right, l, h);
    }

}