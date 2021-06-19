package com.programming.twopointers.leetcode;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;

        int uniqueIndx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndx]) {
                uniqueIndx++;
                nums[uniqueIndx] = nums[i];
            }
        }

        return uniqueIndx + 1;
    }
}
