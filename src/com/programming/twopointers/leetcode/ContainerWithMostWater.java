package com.programming.twopointers.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private static int maxArea(int[] height) {
        int l = 0, r = height.length-1;

        int resArea = 0;

        while (l < r) {
            int width = r-l;
            int length = Math.min(height[l], height[r]);

            if (resArea < width*length) {
                resArea = width*length;
            }

            if (height[l] < height[r])
                l++;
            else r--;
        }

        return resArea;
    }
}
