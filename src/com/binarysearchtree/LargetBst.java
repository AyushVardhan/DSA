package com.binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LargetBst {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Sol T = new Sol();
            System.out.println(T.largestBst(root));

            t--;
        }
    }
}

class Value {

    int max_size = 0;
    boolean is_bst = false;
    int min = Integer.MAX_VALUE;  // For minimum value in right subtree
    int max = Integer.MIN_VALUE;  // For maximum value in left subtree

}

class Sol {


    static int largestBst(Node root) {
        Value val = new Value();
        largestBSTUtil(root, val, val, val, val);
        return val.max_size;
    }

    static int largestBSTUtil(Node node, Value min_ref, Value max_ref,
                              Value max_size_ref, Value is_bst_ref) {

        if (node == null) {
            is_bst_ref.is_bst = true; // An empty tree is BST
            return 0;    // Size of the BST is 0
        }

        int min = Integer.MAX_VALUE;

        /* A flag variable for left subtree property
         i.e., max(root->left) < root->data */
        boolean left_flag = false;

        /* A flag variable for right subtree property
         i.e., min(root->right) > root->data */
        boolean right_flag = false;

        int ls, rs; // To store sizes of left and right subtrees

        /* Following tasks are done by recursive call for left subtree
         a) Get the maximum value in left subtree (Stored in *max_ref)
         b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref)
         c) Get the size of maximum size BST in left subtree (updates *max_size) */
        max_ref.max = Integer.MIN_VALUE;
        ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst && node.data > max_ref.max) {
            left_flag = true;
        }

        /* Before updating *min_ref, store the min value in left subtree. So that we
         have the correct minimum value for this subtree */
        min = min_ref.min;

        /* The following recursive call does similar (similar to left subtree)
         task for right subtree */
        min_ref.min = Integer.MAX_VALUE;
        rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.is_bst && node.data < min_ref.min) {
            right_flag = true;
        }

        // Update min and max values for the parent recursive calls
        if (min < min_ref.min) {
            min_ref.min = min;
        }
        if (node.data < min_ref.min) // For leaf nodes
        {
            min_ref.min = node.data;
        }
        if (node.data > max_ref.max) {
            max_ref.max = node.data;
        }

        /* If both left and right subtrees are BST. And left and right
         subtree properties hold for this node, then this tree is BST.
         So return the size of this tree */
        if (left_flag && right_flag) {
            if (ls + rs + 1 > max_size_ref.max_size) {
                max_size_ref.max_size = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            //Since this subtree is not BST, set is_bst flag for parent calls
            is_bst_ref.is_bst = false;
            return 0;
        }
    }
}