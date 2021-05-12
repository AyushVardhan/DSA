package com.Leetcode.twopointer;

public class MaxAscendingSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{100,10,1}));
    }

    public static int maxAscendingSum(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int sum = nums[0], res = 0;
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] > nums[i-1]) {
                sum += nums[i++];
            }

            res = Math.max(res, sum);
            sum = i < nums.length ? nums[i] : 0;
        }

        return res;
    }
}
