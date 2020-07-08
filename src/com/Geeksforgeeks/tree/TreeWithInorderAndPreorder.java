package com.Geeksforgeeks.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreeWithInorderAndPreorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Node2 root = null;
            int ino[] = new int[n];
            int pre[] = new int[n];
            for (int i = 0; i < n; i++)
                ino[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                pre[i] = sc.nextInt();

            GfG3 gfg = new GfG3(0);
            root = gfg.buildTree(ino, pre, 0, n - 1);
            postOrdrer(root);
            System.out.println();
        }
    }

    public static void postOrdrer(Node2 root) {
        if (root == null)
            return;

        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}

class GfG3 {
    public static int preIndex;
    static Map<Integer, Integer> inOrderMap = new HashMap<>();

    GfG3(int ind) {
        preIndex = ind;
    }

    public static Node2 buildTree(int ino[], int pre[], int st, int end) {
        for (int i = 0; i < ino.length; i++)
            inOrderMap.put(ino[i], i);

        return buildUtil(ino, pre, st, end);
    }

    private static Node2 buildUtil(int[] ino, int[] pre, int st, int end) {
        if (st > end)
            return null;

        Node2 node = new Node2(pre[preIndex]);
        preIndex++;

        if (st == end)
            return node;

        int inorderIndex = inOrderMap.get(node.data);
        node.left = buildUtil(ino, pre, st, inorderIndex - 1);
        node.right = buildUtil(ino, pre, inorderIndex + 1, end);
        return node;
    }
}