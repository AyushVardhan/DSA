package com.Geeksforgeeks.binarysearchtree;

import java.util.ArrayList;
import java.util.Scanner;

public class NormalBSTtoBalancedBST {
    static Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

    }

    int height(Node node) {
        if (node == null) return 0;
        else {
            int lDepth = height(node.left);
            int rDepth = height(node.right);
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node root = null;

            while (n-- > 0) {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            GfG12 gfg = new GfG12();

            root = gfg.buildBalancedTree(root);
            // preOrder(root);
            NormalBSTtoBalancedBST bst = new NormalBSTtoBalancedBST();
            System.out.println(bst.height(root));
        }
    }

    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

class GfG12 {
    ArrayList<Integer> list = new ArrayList<>();

    Node buildBalancedTree(Node root) {
        getSortedArray(root, list);

        Node node = createBalancedBST(0, list.size() - 1);;
        return node;
    }

    private Node createBalancedBST(int s, int e) {
        if (s > e)
            return null;

        int mid = (s + e) / 2;
        Node tmp = new Node(list.get(mid));

        tmp.left = createBalancedBST(s, mid - 1);
        tmp.right = createBalancedBST(mid + 1, e);
        return tmp;
    }

    private void getSortedArray(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        getSortedArray(root.left, list);
        list.add(root.data);
        getSortedArray(root.right, list);
    }
}