package com.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinOperationsToReduceXToZero {
    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{1,1,4,2,3},5));
    }

    private static int minOperations(int[] nums, int x) {
        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        if (totalSum == x)
            return nums.length;

        int reqSum = totalSum - x;

        int res = Integer.MIN_VALUE, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (map.containsKey(sum - reqSum)) {
                res = Math.max(res, r - map.get(sum - reqSum));
            }
            map.put(sum, r);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}
