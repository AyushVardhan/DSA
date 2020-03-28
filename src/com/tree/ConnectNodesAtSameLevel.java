package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node2 left;
    Node2 right;
    Node2 nextRight;

    Node2(int data) {
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
    }
}

public class ConnectNodesAtSameLevel {
    static Node2 buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node2 root = new Node2(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node2> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node2 currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node2(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node2(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void printInorder(Node2 root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void printSpecial(Node2 root) {
        if (root == null)
            return;

        Node2 next_root = null;

        while (root != null) {
            System.out.print(root.data + " ");

            if (root.left != null && next_root == null)
                next_root = root.left;
            else if (root.right != null && next_root == null)
                next_root = root.right;

            root = root.nextRight;
        }

        printSpecial(next_root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node2 root = buildTree(s);
            Tree2 g = new Tree2();
            g.connect(root);
            printSpecial(root);
            System.out.println();
            printInorder(root);
            System.out.println();
            t--;

        }
    }
}

class Tree2 {
    public static void connect(Node2 p) {
        // code here.
        if (p == null)
            return;

        Queue<Node2> queue = new LinkedList<>();
        queue.add(p);

        Queue<Node2> newQ = new LinkedList<>();
        while (true) {
            int size = queue.size();
            if (size == 0)
                break;

            while (size > 0) {
                Node2 tmp = queue.remove(), next;
                while (tmp != null) {
                    next = queue.size() > 0 ? queue.remove() : null;
                    tmp.nextRight = next;
                    if (tmp.left != null) newQ.add(tmp.left);
                    if (tmp.right != null) newQ.add(tmp.right);
                    tmp = next;
                    size--;
                }
            }

            queue.addAll(newQ);
            newQ.clear();
        }
    }
}