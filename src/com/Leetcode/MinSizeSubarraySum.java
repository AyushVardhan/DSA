package com.Leetcode;

public class MinSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    private static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int length = nums.length;
        int sum = 0, minsize = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++){
            sum += nums[i];
            while (sum >= s && start < length){
                minsize = Math.min(minsize,i + 1 - start);
                sum = sum - nums[start++];
            }
        }

        return minsize != Integer.MAX_VALUE ? minsize : 0;
    }
}
