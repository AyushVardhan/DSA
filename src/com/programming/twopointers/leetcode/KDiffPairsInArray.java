package com.programming.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2)
                    cnt++;
            } else {
                if (map.containsKey(entry.getKey() + k))
                    cnt++;
            }
        }

        return cnt;
    }


//    Direct Two Pointer _ Brute Force - O(n * n)
//
//    private static int findPairs(int[] nums, int k) {
//        Arrays.sort(nums);
//        int cnt = 0;
//
//        if (k == 0) {
//            for (int i = 0; i < nums.length-1; i++) {
//                if (nums[i] == nums[i+1])
//                    cnt++;
//                while (i < nums.length-1 && nums[i] == nums[i+1])
//                    i++;
//            }
//        } else {
//            for (int i = 0; i < nums.length-1; i++) {
//                while (i < nums.length-1 && nums[i] == nums[i+1])
//                    i++;
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j]- nums[i] == k) {
//                        cnt++;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return cnt;
//    }
}
