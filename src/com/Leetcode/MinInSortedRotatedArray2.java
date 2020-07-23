package com.Leetcode;

public class MinInSortedRotatedArray2 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,2,3,0,0,1,2}));
    }

    private static int findMin(int[] nums) {
        if (nums.length <= 0)
            return 0;

        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];

        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int mid = (l + h) / 2;

            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else if (nums[mid] < nums[l]) {
                l++;
                h = mid;
            } else { // nums[lo] <= nums[mi] <= nums[hi]
                h--;
            }
        }

        return nums[l];
    }

}

