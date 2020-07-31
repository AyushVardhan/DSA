package com.Leetcode;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));
    }

    private static int missingNumber(int[] nums) {

        if (nums.length <= 0)
            return 0;


        int max = nums.length;
        int sum = 0;

        for (int data : nums){
            sum += data;
        }

        int reqSum = ((max) * (max + 1))/2;
        return reqSum - sum;
    }
}
