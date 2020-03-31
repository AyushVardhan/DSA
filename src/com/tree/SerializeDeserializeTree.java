package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree11 tr = new Tree11();
            ArrayList<Integer> A = new ArrayList<Integer>();
            tr.serialize(root, A);

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();
        }
    }
}

class Tree11 {
    public void serialize(Node root, ArrayList<Integer> A) {
        if (root == null) {
            A.add(-1);
            return;
        }

        A.add(root.data);
        serialize(root.left, A);
        serialize(root.right, A);
    }


    public Node deSerialize(ArrayList<Integer> A) {
        Passing pas = new Passing();
        pas.index = 0;
        return util(A, pas);
    }

    private Node util(ArrayList<Integer> a, Passing pas) {
        if (pas.index == a.size() || a.get(pas.index) == -1) {
            pas.index += 1;
            return null;
        }

        Node node = new Node(a.get(pas.index));
        pas.index = pas.index + 1;

        node.left = util(a, pas);
        node.right = util(a, pas);
        return node;
    }

    class Passing {
        int index;
    }
}