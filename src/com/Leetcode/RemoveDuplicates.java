package com.Leetcode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[i] == nums[j])
                continue;

            i = i + 1;
            nums[i] = nums[j];
        }

        return i+1;
    }
}
