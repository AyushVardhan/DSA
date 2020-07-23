package com.Leetcode;

public class MinInSortedRotatedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,1,2,3}));
    }

    private static int findMin(int[] nums) {
        if (nums.length <= 0)
            return 0;

        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];

        int l = 0, pivot = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;

            if (nums[l] <= nums[mid] && nums[mid + 1] < nums[mid]) {
                pivot = mid;
                break;
            } else if (nums[l] <= nums[mid] && nums[mid + 1] > nums[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return Math.min(nums[pivot + 1], nums[0]);
    }

}
