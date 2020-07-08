package com.Geeksforgeeks.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreeWithInorderAndPostOrder {
    public void preOrder(Node2 root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TreeWithInorderAndPostOrder ip = new TreeWithInorderAndPostOrder();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG2 g = new GfG2();
            Node2 root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

class GfG2 {

    int index;
    Map<Integer, Integer> inOrderMap = new HashMap<>();

    // Complete the function
    Node2 buildTree(int in[], int post[], int n) {
        // Your code here
        index = n - 1;

        for (int i = 0; i < n; i++)
            inOrderMap.put(in[i], i);

        return buildUtil(in, post, 0, n - 1);
    }

    private Node2 buildUtil(int[] in, int[] post, int start, int end) {
        if (start > end)
            return null;

        Node2 node = new Node2(post[index]);
        index--;

        if (start == end)
            return node;

        int inorderIndex = inOrderMap.get(node.data);
        node.right = buildUtil(in,post,inorderIndex+1,end);
        node.left = buildUtil(in,post,start,inorderIndex-1);
        return node;
    }
}
