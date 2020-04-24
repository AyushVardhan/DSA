package com.binarysearchtree;

import java.util.Scanner;

public class LevelOrderToBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

}

class GFG {

    public Node constructBST(int[] arr) {
        Node root = null;

        for (Integer data : arr) {
            root = buildBST(root, data);
        }

        return root;
    }

    private Node buildBST(Node root, Integer data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.data >= data) {
            root.left = buildBST(root.left, data);
        } else {
            root.right = buildBST(root.right, data);
        }

        return root;
    }
}
