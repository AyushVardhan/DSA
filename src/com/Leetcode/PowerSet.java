package com.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length <= 0)
            return new ArrayList<>();

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, subset, res);
        return res;
    }

    private static void helper(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        for (int i = pos; i < nums.length; ++i) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }

}
