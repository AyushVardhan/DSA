package com.Geeksforgeeks.binarysearchtree;

import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class SearchNode {
    void insert(Node root, int key) {

        if (key < root.data) {
            if (root.left != null)
                insert(root.left, key);
            else
                root.left = new Node(key);
        } else if (key > root.data) {
            if (root.right != null)
                insert(root.right, key);
            else
                root.right = new Node(key);
        }

    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            SearchNode obj = new SearchNode();
            int a1 = sc.nextInt();
            Node root = new Node(a1);

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                obj.insert(root, a);
            }

            int s = sc.nextInt();
            BST g = new BST();
            if (g.search(root, s) == true)
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }

    }
}

class BST {

    boolean found = false;

    boolean search(Node root, int x) {

        if (root == null)
            return false;

        if (root.data == x)
            return true;

        if (root.data > x)
            return search(root.left,x);

        return search(root.right, x);

//        Another Way
//        if (root == null)
//            return false;
//
//        searchUtil(root, x);
//        return found;
    }

    private void searchUtil(Node root, int x) {
        if (found || root == null)
            return;

        if (root.data == x) {
            found = true;
        }

        if (root.data > x)
            search(root.left, x);
        else
            search(root.right, x);
    }
}