package com.Leetcode.slidingWindow;

public class LongestContiguousSubarrayWithAbsDiffLessThanLimit {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int min = nums[0], max = nums[0], res = 1, l = 0;

        for (int r = 0; r < nums.length; r++) {
            min = Math.min(min,nums[r]);
            max = Math.max(max,nums[r]);

            if (Math.abs(min-max) > limit) {
                l++;
                min = nums[l];
                max = nums[l];
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
