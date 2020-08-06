package com.Leetcode;

public class LongestConsecutiveOne {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                count++;
                continue;
            }

            res = Math.max(count,res);
            count = 0;
        }

        return Math.max(count,res);
    }
}
