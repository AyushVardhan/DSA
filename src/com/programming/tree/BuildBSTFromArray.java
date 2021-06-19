package com.programming.tree;

public class BuildBSTFromArray {
    static int l = 0;

    public static void main(String[] args) {
        TreeNode root = build(new int[]{10, 2, 3, 11, 15}, null, null);
        System.out.println(root);
    }

    private static TreeNode build(int[] a, Integer min, Integer max) {
        if (l + 1 > a.length)
            return null;

        if ((min != null && a[l] <= min) || (max != null && a[l] >= max))
            return null;

        TreeNode root = new TreeNode(a[l++]);

        root.left = build(a,min,root.val);
        root.right = build(a,root.val, max);

        return root;
    }
}
