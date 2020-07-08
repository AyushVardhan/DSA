package com.Leetcode;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] nums) {
        int max_soFar = nums[0], maxEndingHere = nums[0], s=0, e =0;
        for (int i = 1; i < nums.length; i++) {

            if (maxEndingHere + nums[i] > nums[i]){
                maxEndingHere = maxEndingHere + nums[i];
            }else {
                maxEndingHere = nums[i];
                s = i;
            }

            if (maxEndingHere > max_soFar){
                max_soFar = maxEndingHere;
                e = i;
            }
        }

        System.out.println("Start : " + s +", End : " +e);
        return max_soFar;
    }
}
