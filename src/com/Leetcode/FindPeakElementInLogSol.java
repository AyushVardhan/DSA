package com.Leetcode;

public class FindPeakElementInLogSol {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }

    private static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private static int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
