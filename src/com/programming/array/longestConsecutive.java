package com.programming.array;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {
    public static void main(String[] args) {
        System.out.println(lngestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    private static int lngestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : nums) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentCount = 1;

                while (set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentCount += 1;
                }

                res = Math.max(res, currentCount);
            }
        }

        return res;
    }
}
