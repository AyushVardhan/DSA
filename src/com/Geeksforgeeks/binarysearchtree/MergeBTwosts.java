package com.Geeksforgeeks.binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MergeTwoBsts {
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
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Soluti T = new Soluti();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

class Soluti {

    public List<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> list1 = storeInorderUtil(root1, new ArrayList<>());
        ArrayList<Integer> list2 = storeInorderUtil(root2, new ArrayList<>());
        return merge(list1, list2, list1.size(), list2.size());
    }

    ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {
        ArrayList<Integer> list3 = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        while (i < m) {
            list3.add(list1.get(i));
            i++;
        }

        while (j < n) {
            list3.add(list2.get(j));
            j++;
        }
        return list3;
    }

    public ArrayList<Integer> storeInorderUtil(Node node, ArrayList<Integer> list) {
        if (node == null)
            return list;

        storeInorderUtil(node.left, list);
        list.add(node.data);
        storeInorderUtil(node.right, list);
        return list;
    }
}