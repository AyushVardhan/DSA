package com.Geeksforgeeks.binarysearchtree;

import java.util.Scanner;

class Res {
    Node pre = null;
    Node succ = null;
}

public class PredecessorAndSuccessor {
    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Res p = new Res();
            Res s = new Res();
            for (int i = 0; i < n; i++) {

                int a = sc.nextInt();
                int a1 = sc.nextInt();

                char lr = sc.next().charAt(0);

                if (i == 0) {

                    root = new Node(a);

                    switch (lr) {

                        case 'L':
                            root.left = new Node(a1);
                            break;
                        case 'R':
                            root.right = new Node(a1);
                            break;
                    }
                } else {
                    insert(root, a, a1, lr);
                }
            }

            int key = sc.nextInt();
            GfG1 g = new GfG1();
            g.findPreSuc(root, p, s, key);

            if (p.pre != null)
                System.out.print(p.pre.data + " ");
            else
                System.out.print("-1" + " ");

            if (s.succ != null)
                System.out.println(s.succ.data);
            else
                System.out.println("-1");


        }
    }
}

class GfG1 {

    public static void findPreSuc(Node root, Res p, Res s, int key){
        if (root==null)
            return;

        if (root.data == key){
            if (root.left != null){
                Node tmp = root.left;
                while (tmp.right != null){
                    tmp = tmp.right;
                }

                p.pre = tmp;
            }

            if (root.right != null){
                Node tmp = root.right;
                while (tmp.left != null){
                    tmp = tmp.left;
                }

                s.succ = tmp;
            }
            return;
        }

        if (root.data > key){
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        }else {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        }
    }

    public static void findPreSucInOrderN(Node root, Res p, Res s, int key) { // Time Complexity -> O(n)
        // add your code here
        if (root == null)
            return;

        if (root.data == key) {
            p.pre = root.left == null ? p.pre : root.left;
            s.succ = root.right == null ? s.succ : root.right;
        }

        if (root.data > key) {
            if (s.succ == null) {
                s.succ = root;
            } else if (root.data < s.succ.data) {
                s.succ = root;
            }
        }

        if (root.data < key){
            if (p.pre == null) {
                p.pre = root;
            } else if (root.data > p.pre.data) {
                p.pre = root;
            }
        }

        findPreSuc(root.left, p, s, key);
        findPreSuc(root.right, p, s, key);
    }
}
