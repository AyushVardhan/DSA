package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public static void main(String[] args) {


        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);

        System.out.println(isCousins(node, 4, 4));
    }
//
//    static TreeNode parentX = null, parentY = null;
//    static int depthX = -1, depthY = -2;
//
//    public static boolean isCousins(TreeNode root, int x, int y) {
//        dfs(root, x, y, 0, null);
//        return depthX == depthY && parentX != parentY;
//    }
//
//    static private void dfs(TreeNode node, int x, int y, int depth, TreeNode parent) {
//        if (node == null)
//            return;
//        else if (node.val == x) {
//            parentX = parent;
//            depthX = depth;
//        } else if (node.val == y) {
//            parentY = parent;
//            depthY = depth;
//        } else {
//            dfs(node.left, x, y, depth+1, node);
//            dfs(node.right, x, y, depth+1, node);
//        }
//    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xExist = false;
            boolean yExist = false;

            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.val == x) xExist = true;
                if (curr.val == y) yExist = true;

                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.right.val == x && curr.left.val == y)
                        return false;
                }

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }

            if (xExist && yExist) return true;
        }

        return false;
    }

//    **** Code to get parent ****
//
//    private static TreeNode prev = null;
//
//    private static TreeNode getParent(TreeNode root, int x, TreeNode parent) {
//        if (root == null)
//            return root;
//        else if (x == root.val)
//            prev = parent;
//        else {
//            root.left = getParent(root.left, x, root);
//            root.right = getParent(root.right, x, root);
//        }
//
//        return root;
//    }
}
