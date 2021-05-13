package com.twopointers.leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    private static int trap(int[] height) {
        int res = 0;
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];

        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            tmp = Math.max(tmp,height[i]);
            lMax[i] = tmp;
        }

        tmp = Integer.MIN_VALUE;
        for (int i = height.length-1; i >= 0; i--) {
            tmp = Math.max(tmp,height[i]);
            rMax[i] = tmp;
        }

        for (int i = 0; i < height.length; i++) {
            res += (Math.min(lMax[i], rMax[i]) - height[i]);
        }

        return res;
    }


}
