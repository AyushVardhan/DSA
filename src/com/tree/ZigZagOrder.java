package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagOrder {
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

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    /* Drier program to test above functions */
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            GFG g = new GFG();

            g.zigZagTraversal(root);

            System.out.println();

            t--;

        }
    }
}

class GFG {
    void zigZagTraversal(Node root) {
        //Add your code here.

        Stack<Node> currStack = new Stack<>();
        Stack<Node> nextStack = new Stack<>();

        boolean ltr = true;

        currStack.push(root);

        while (!currStack.empty()) {
            Node pop = currStack.pop();
            System.out.print(pop.data + " ");

            if (ltr) {
                if (pop.left != null)
                    nextStack.push(pop.left);

                if (pop.right != null)
                    nextStack.push(pop.right);
            } else {
                if (pop.right != null)
                    nextStack.push(pop.right);

                if (pop.left != null)
                    nextStack.push(pop.left);
            }

            if (currStack.isEmpty()){
                ltr = !ltr;

                Stack<Node> tmp = currStack;
                currStack = nextStack;
                nextStack = tmp;
            }
        }
    }
}