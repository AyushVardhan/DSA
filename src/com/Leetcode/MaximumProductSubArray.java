package com.Leetcode;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }

    private static int maxProduct(int[] nums) {
        if (nums.length <= 0)
            return 0;

        int maxProdEndingHere = nums[0];
        int maxProdSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] * maxProdEndingHere > maxProdEndingHere) {
                maxProdEndingHere = nums[i] * maxProdEndingHere;
            } else {
                maxProdEndingHere = nums[i];
            }

            if (maxProdEndingHere > maxProdSoFar)
                maxProdSoFar = maxProdEndingHere;
        }

        return maxProdSoFar;
    }
}
