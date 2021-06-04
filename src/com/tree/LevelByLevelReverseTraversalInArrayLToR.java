package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelByLevelReverseTraversalInArrayLToR {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(reverseTraversal(node));
    }

    private static List<List<Integer>> reverseTraversal(TreeNode node) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == node)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                list.add(cur.val);

                if (cur.left != null)
                    queue.add(cur.left);

                if (cur.right != null)
                    queue.add(cur.right);
            }

            result.add(0, list);
        }

        return result;
    }
}
