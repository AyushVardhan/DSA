package com.programming.tree;

//  You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can
//  monitor its parent, itself, and its immediate children.
//
//        Return the minimum number of cameras needed to monitor all nodes of the tree.
//


public class BinaryTreeCameras {

    static int res  = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left =  new TreeNode(4);
        node.left.right =  new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);


        int val = minCameraCover(node);
        System.out.println(res + (val < 1 ? 1 : 0));
    }

    private static int minCameraCover(TreeNode node) {
        if (node == null)
            return 2;

        int left = minCameraCover(node.left), right = minCameraCover(node.right);

        if (left == 0 || right == 0) {
            res++;
            return 1;
        }

        return left == 1 || right == 1 ? 2 : 0;

        // 0 : leaf node
        // 1 : parent node & camera required
        // 2 : already covered without camera at this node
    }
}
