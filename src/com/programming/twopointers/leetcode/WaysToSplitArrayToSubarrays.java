package com.programming.twopointers.leetcode;

public class WaysToSplitArrayToSubarrays {
    public static void main(String[] args) {
        System.out.println(waysToSplit(new int[]{2,1,1,1,1,1,1,1,1}));
    }

    private static int waysToSplit(int[] nums) {
        int MOD = 1000000007;
        int n = nums.length, res = 0;

        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        for (int i = 0, j = 0, k = 0; i < n - 2; i++) {
            while (j <= i || (j < n - 1 && nums[j] < 2 * nums[i]))
                j++;
            while (k < j || (k < n - 1 && nums[k] - nums[i] <= nums[n - 1] - nums[k]))
                k++;

            res = (res + k - j) % MOD;
        }

        return res;
    }
}


/*

[2,1,1,1,1,1,1,1,1]

(sum of midArray)    (sum of rightArray)
nums[k] - nums[i] <= nums[n - 1] - nums[k]

-> 2*nums[k] <= nums[n - 1] + nums[i]
-> nums[k] <= (nums[n - 1] + nums[i])/2







 */











