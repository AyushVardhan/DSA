package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.right =  new TreeNode(3);
        node.right.right =  new TreeNode(4);
        node.right.right.right =  new TreeNode(5);
        node.right.right.right.right =  new TreeNode(6);

        System.out.println(getMinDepthRecursive(node));
    }

    private static int getMinDepth(TreeNode node) {
        if (null == node)
            return 0;

        Queue<TreeNode> tmpQue = new LinkedList<>();
        tmpQue.add(node);
        int minLength = 0;

        while (!tmpQue.isEmpty()) {
            minLength++;
            int size = tmpQue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = tmpQue.poll();
                if (cur.left == null && cur.right == null)
                    return minLength;

                if (cur.left != null)
                    tmpQue.add(cur.left);

                if (cur.right != null)
                    tmpQue.add(cur.right);
            }
        }

        return minLength;
    }

    private static int getMinDepthRecursive(TreeNode node) {
        if (node == null)
            return 0;

        int left = getMinDepthRecursive(node.left);
        int right = getMinDepthRecursive(node.right);

        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }
}
