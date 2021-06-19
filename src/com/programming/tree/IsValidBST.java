package com.programming.tree;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.right =  new TreeNode(3);
        node.left = new TreeNode(1);

        boolean validBST = isValidBST(node);
        System.out.println(validBST);
    }

    private static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private  static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
