package com.programming.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(9);

        int x = widthOfBinaryTree(node);
        System.out.println(x);
    }

    private static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int res = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> first = queue.peek();
            Pair<TreeNode, Integer> curr = null;
            int size = queue.size();

            while (size-- > 0) {
                curr = queue.poll();
                TreeNode node = curr.getKey();
                Integer idx = curr.getValue();

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, idx * 2));
                }

                if (node.right!= null)
                    queue.add(new Pair<>(node.right, idx * 2 + 1));
            }

            res = Math.max(res, curr.getValue() - first.getValue() + 1);
        }

        return res;
    }
}
