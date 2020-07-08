package com.Leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(arr, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int left=0;
        int right=0;
        int count=0;

        while(right<nums.length){
            if(nums[right]==val){
                right++;
            }
            else {
                int temp = nums[left];
                nums[left] =nums[right];
                nums[right] = temp;
                left++;
                right++;
                count++;
            }
        }
        return count;
    }
}
