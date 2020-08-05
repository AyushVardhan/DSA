package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] > 0) {
                nums[idx - 1] = -nums[idx - 1];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                list.add(i+1);
        }

        return list;
    }
}
