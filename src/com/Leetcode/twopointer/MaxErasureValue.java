package com.Leetcode.twopointer;

import java.util.HashSet;
import java.util.Set;

public class MaxErasureValue {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }

    static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int i = 0, r =0; int resL = 0, resR = 0, res = 0;
        for (; r < nums.length; r++) {
            if (set.contains(nums[r])) {
                if (res < r-i+1) {
                    res = r-i+1;
                    resL = i;
                    resR = r-1;
                }
                set.clear();
                i = i + 1;
                r = i;
                set.add(nums[r]);
            } else {
                set.add(nums[r]);
            }
        }

        if (res < r-i+1) {
            res = r-i+1;
            resL = i;
            resR = r-1;
        }

        int sum = 0;
        for (int k = resL; k <= resR; k++){
            sum += nums[k];
        }

        return sum;
    }
}
