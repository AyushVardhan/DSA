package com.leetcode.array;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int arr[] = new int[]{-3,-2,-1,0,0,1,2,3};
        System.out.println(fourSum(arr, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int l, h, sum;
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n - 4; i++) {
            for (int j = i + 1; j <= n - 3; j++) {
                l = j + 1;
                h = n - 1;

                while (l < h && h <= (n - 1)) {
                    sum = nums[i] + nums[j] + nums[l] + nums[h];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        l++;
                        h--;
                    } else if (sum < target) {
                        l++;
                    } else h--;
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(set);

        return list;
    }
}