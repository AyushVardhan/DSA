package com.dp;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    // T(N) -> O(n^2)
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxans = 1;

        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }

    // Naive approach in mind:
    /* This wont work. Example - it wont pass this input -> [0,1,0,3,2,3]. Correct ans -> 4. Code gives -> 3. So,
    we need to use DP and get maxSum from all previous possibilities.

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = 1, max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[max]) {
                    min++;
                    max = j;
                }
            }

            res = Math.max(res, min);
        }

        return res;

     */
}
