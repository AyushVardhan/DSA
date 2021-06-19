package com.programming.twopointers.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    private static int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0;
        int ans = 0, sum = 0, n = nums.length;
        Set<Integer> set = new HashSet<>();

        while (l < n && r < n) {
            if (!set.contains(nums[r])) {
                sum += nums[r];
                set.add(nums[r++]);
                ans = Math.max(ans, sum);
            } else {
                sum -= nums[l];
                set.remove(nums[l++]);
            }
        }

        return ans;
    }
}
