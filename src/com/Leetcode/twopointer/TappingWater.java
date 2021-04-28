package com.Leetcode.twopointer;

public class TappingWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }

    private static int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];

        int cmp = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cmp = Math.max(cmp, height[i]);
            lMax[i] = cmp;
        }

        cmp = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--) {
            cmp = Math.max(cmp, height[i]);
            rMax[i] = cmp;
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }

        return res;
    }
}
