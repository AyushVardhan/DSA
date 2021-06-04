package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left =  new TreeNode(4);
        node.left.right =  new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        levelOrderSiblings(node);
        System.out.println(node);
    }

    private static void levelOrderSiblings(TreeNode node) {
        if (node == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur.left != null)
                    queue.add(cur.left);

                if (cur.right != null)
                    queue.add(cur.right);

                if (i == size - 1)
                    cur.next = null;
                else
                    cur.next = queue.peek();
            }
        }
    }
}
