package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverageInBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(7);
        node.left.left = new TreeNode(9);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(10);
        node.right.right = new TreeNode(5);

        System.out.println(findLevelAverages(node));
    }

    private static List<Double> findLevelAverages(TreeNode node) {
        List<Double> resList = new ArrayList<>();
        if (node == null)
            return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null)
                    queue.add(cur.left);

                if (cur.right != null)
                    queue.add(cur.right);
            }

            resList.add((double) sum / size);
        }

        return resList;
    }
}
