package com.programming.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(7);
        node.left.left =  new TreeNode(9);
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(10);
        node.right.left.left = new TreeNode(20);
        node.right.left.right = new TreeNode(17);
        node.right.right = new TreeNode(5);

        System.out.println(zigzagTraversal(node));
    }

    private static List<List<Integer>> zigzagTraversal(TreeNode node) {

        List<List<Integer>> resList = new LinkedList<>();

        if (null == node)
            return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        boolean rightDir = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (rightDir)
                   tmpList.add(cur.val);
               else
                   tmpList.add(0, cur.val);

               if (null != cur.left)
                   queue.add(cur.left);

               if (null != cur.right)
                   queue.add(cur.right);
            }

            resList.add(tmpList);
            rightDir = !rightDir;
        }

        return resList;
    }
}
