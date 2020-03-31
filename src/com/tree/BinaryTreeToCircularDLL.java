package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToCircularDLL {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
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
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    static void displayCList(Node head) {
        Node itr = head;
        do {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head != itr);
        System.out.println();
        itr = itr.left;
        do {
            System.out.print(itr.data + " ");
            itr = itr.left;
        } while (head != itr);
        System.out.println(itr.data + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree12 boj = new Tree12();
            Node head = boj.bTreeToClist(root);
            displayCList(head);

        }

    }
}

class Tree12 {

    Node head, prev;

    Node bTreeToClist(Node root) {
        util(root);
        return head;
    }

    private void util(Node root) {
        if (root == null)
            return;

        util(root.left);

        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        util(root.right);
        prev.right = head;
        head.left = prev;
    }

}