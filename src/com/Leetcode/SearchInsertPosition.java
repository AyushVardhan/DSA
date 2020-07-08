package com.Leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {

        int arr[] = new int[]{1,3,5,7};
        int target = 8;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return findPosition(nums, target);
    }

    private static int findPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (target < nums[0]) {
            return 0;
        }

        if (target > nums[r]) {
            return nums.length;
        }

        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (mid > 0 && (mid == nums.length - 1 || (nums[mid - 1] < target && nums[mid + 1] > target && nums[mid] > target))) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
