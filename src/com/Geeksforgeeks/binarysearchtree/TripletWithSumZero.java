package com.Geeksforgeeks.binarysearchtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TripletWithSumZero {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }

            Gf gfg = new Gf();
            boolean res = gfg.isTriplet(root);

            if(res == true)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static Node insert(Node root, int x)
    {
        if(root == null)
        {
            return (new Node(x));
        }

        if(x < root.data)
        {
            root.left = insert(root.left, x);
        }
        else if(x > root.data)
        {
            root.right = insert(root.right, x);
        }

        return root;
    }
}

class Gf
{
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int sum = 0;
    public static boolean isTriplet(Node root)
    {
        list = new ArrayList<>();
        preorder(root);
        boolean res = isTripletUtil(root, sum);
        return res;

    }

    public static void preorder(Node root)
    {   if(root == null)
        return;

        preorder(root.left);
        list.add(root.data);
        preorder(root.right);
    }

    public static boolean isTripletUtil(Node root, int sum)
    {
        for(int i = 0; i < list.size()-1; i++)
        {
            Set<Integer> set = new HashSet<Integer>();
            int rem = sum - list.get(i);
            for(int j = i+1; j < list.size(); j++)
            {
                if(set.contains(rem - list.get(j)))
                {//System.out.println(list.get(i)+" "+list.get(j)+" "+(rem - list.get(j)));
                    return true;
                }
                set.add(list.get(j));
            }
        }
        return false;
    }
}