package com.Leetcode;

public class TappingRainWater {
    public static void main(String[] args) {
        int arr[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }

    private static int trap(int[] height) {
        int n = height.length, sum = 0;
        int left[] = new int[n];
        int right[] = new int[n];

        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            tmp = Math.max(height[i],tmp);
            left[i] = tmp;
        }

        tmp = Integer.MIN_VALUE;
        for (int i = n-1; i >= 0; i--) {
            tmp = Math.max(height[i],tmp);
            right[i] = tmp;
        }

        for (int i = 0; i <  n ; i++){
            if (height[i]==left[i] || height[i]==right[i])
                continue;

            int val = Math.min(left[i],right[i]);
            sum += Math.abs(val - height[i]);
        }

        return sum;
    }
}
