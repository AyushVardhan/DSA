package com.programming.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafWithMaxSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.right = new TreeNode(3);

        System.out.println(getMaxPath(node));
    }

    private static List<Integer> getMaxPath(TreeNode node) {
        if (node != null) {
            ArrayList<Integer> list = new ArrayList<>();
            getMax(node, 0, list);
            return resList;
        }

        return new ArrayList<>();
    }

    static int maxSum = 0;
    static List<Integer> resList;

    private static void getMax(TreeNode node, int sum, List<Integer> list) {


        list.add(node.val);

        if (node.left == null && node.right == null) {
            if (maxSum < sum + node.val) {
                maxSum = sum + node.val;
                resList = new ArrayList<>(list);
            }
        }


        if (node.left != null) {
            getMax(node.left, sum + node.val, list);
            list.remove(list.size() - 1);
        }

        if (node.right != null) {
            getMax(node.right, sum + node.val, list);
            list.remove(list.size() - 1);
        }
    }
}
