package com.leetcode.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    private static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1, len, wid, area = 0;

        while (left < right) {
            len = Math.min(height[left], height[right]);
            wid = right - left;
            area = Math.max((len * wid), area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return area;
    }
}
