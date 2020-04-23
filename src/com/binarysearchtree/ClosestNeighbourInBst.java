package com.binarysearchtree;

import java.util.Scanner;

public class ClosestNeighbourInBst {
    public static Node insert(Node node, int data)
    {
        if (node == null)
        {
            return (new Node(data));
        } else
        {

            /* 2. Otherwise, recur down the tree */
            if (data <= node.data)
            {
                node.left = insert(node.left, data);
            } else
            {
                node.right = insert(node.right, data);
            }

            /* return the (unchanged) node pointer */
            return node;
        }

    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;


            while(n-- > 0)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            int N = sc.nextInt();

            GfG gfg = new GfG();
            System.out.println(gfg.findMaxforKey(root, N, n));
        }


    }
}

class GfG
{
    public static int findMaxforKey(Node node, int val, int size)
    {
        if (node == null)
            return -1;

        if (node.data == val)
            return val;

        else if (node.data > val){
            return findMaxforKey(node.left, val, size);
        }

        else {
            int k = findMaxforKey(node.right,val,size);
            if (k == -1)
                return node.data;
            else
                return k;
        }
    }
}