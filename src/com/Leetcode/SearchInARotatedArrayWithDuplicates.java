package com.Leetcode;

public class SearchInARotatedArrayWithDuplicates {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 1, 1, 1}, 3));
    }

    private static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) {
            if (target == nums[0]) return true;
            else return false;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid] || target == nums[left] || target == nums[right]) return true;

            // check duplicates
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            // If left array is sorted
            if (nums[left] < nums[mid]) {
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // if right array is sorted
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

            // if both arrays are not sorted then we have already checked the left and right . so move both pointers
            else {
                right--;
                left++;
            }
        }

        return false;
    }
}
