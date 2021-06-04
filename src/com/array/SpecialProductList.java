package com.array;

/*

Given a list of integers nums, return a new list such that each element at index i of the new list is the product of all the
numbers in the original list except the one at i. Do this without using division.

 */

import java.util.Arrays;

public class SpecialProductList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getResult(new int[]{2,3,4,5,6})));
    }

    // T(N) -> O(N), S(N) -> O(1)
    private static int[] getResult(int[] nums) {
        int len = nums.length;
        int[] prod = new int[len];

        int tmp = 1;

        for (int i = 0; i < len; i++) {
            prod[i] = tmp;
            tmp = tmp * nums[i];
        }

        tmp = 1;
        for (int i = len-1; i >= 0; i--) {
            prod[i] = prod[i] * tmp;
            tmp = tmp * nums[i];
        }

        return prod;
    }


    // T(N) -> O(N), S(N) -> O(1)
    /*

    private static int[] getResult(int[] nums) {
        int prod = 1;
        for (int num : nums) {
            prod *= num;
        }

        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = (int) ((double) prod * Math.pow(nums[i], -1));
        }

        return res;
    }

     */


    // T(N) -> O(N), S(N) -> 2.O(N)
    /*


    private static int[] getResult(int[] nums) {
        int len = nums.length;
        if (len <= 0)
            return new int[len];

        int[] res = new int[len];
        int[] leftProdVals = new int[len];
        int[] rightProdVals = new int[len];

        leftProdVals[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftProdVals[i] = nums[i] * leftProdVals[i-1];
        }

        rightProdVals[len-1] = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            rightProdVals[i] = nums[i] * rightProdVals[i+1];
        }

        res[0] = rightProdVals[1];
        res[len-1] = leftProdVals[len-2];

        for (int i = 1; i <= len-2; i++) {
            res[i] = leftProdVals[i-1] * rightProdVals[i+1];
        }

        return res;
    }


     */
}
