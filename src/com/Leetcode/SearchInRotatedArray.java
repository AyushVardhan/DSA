package com.Leetcode;

public class SearchInRotatedArray {
    public static void main(String[] args) {

        int arr[] = new int[]{4,5,6,7,0,1,2};
        int target = 2;
        System.out.println(search(arr,target));
    }

    private static int search(int[] nums, int target) {
        int l = 0, r = nums.length-1,mid;

        while (l <= r){
            mid = (l + r)/2;
            if (nums[mid]==target)
                return mid;

            if (l == r)
                break;

            if (nums[l] <= nums[mid]){
                if (nums[l] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (target >= nums[mid] && target<= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
