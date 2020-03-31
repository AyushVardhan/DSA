package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToDLL {
    static Node buildTree(String str) throws IOException {

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


    void inorder(Node node) {
        if (node == null)
            return;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void printList(Node head) {
        Node prev = head;
        while (head != null) {
            System.out.print(head.data + " ");
            prev = head;
            head = head.right;
        }

        System.out.println();
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.left;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            GfG1 g = new GfG1();

            Node ans = g.bToDLL(root);
            printList(ans);
            t--;
            System.out.println();
        }


    }
}

class GfG1 {
    Node head, prev;

    Node bToDLL(Node root) {
        util(root);
        return head;
    }

    private void util(Node root) {
        if (root == null)
            return;

        bToDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        bToDLL(root.right);
    }
}
