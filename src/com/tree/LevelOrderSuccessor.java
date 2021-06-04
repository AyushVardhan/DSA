package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left =  new TreeNode(4);
        node.left.right =  new TreeNode(5);
        node.right = new TreeNode(3);

        System.out.println(getLevelOrderSuccessor(node, 2));
    }

    private static TreeNode getLevelOrderSuccessor(TreeNode node, int key) {
        if (node == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null)
                queue.add(cur.left);

            if (cur.right != null)
                queue.add(cur.right);

            if (cur.val == key)
                break;
        }
        return queue.peek();
    }
}
