package com.Leetcode;

public class LastAndFirstElement {
    public static void main(String[] args) {

        int arr[] = new int[]{1,2,3,3,3,3,3,3,8};
        int target = 2;

        int[] range = searchRange(arr, target);

        for (int a : range) {
            System.out.println(a);
        }
    }

    private static int[] searchRange(int[] nums, int target) {
        int arr[] = new int[]{-1, -1};

        if (nums.length < 1) {
            return arr;
        }

        arr[0] = searchFirst(nums, target);
        arr[1] = searchLast(nums, target);

        return arr;
    }

    private static int searchLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;

        if (nums[r] == target)
            return r;

        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target && nums[mid + 1] > target) {
                return mid;
            } else if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    private static int searchFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;

        if (nums[l] == target)
            return l;

        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target && nums[mid - 1] < target) {
                return mid;
            }

            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


}
