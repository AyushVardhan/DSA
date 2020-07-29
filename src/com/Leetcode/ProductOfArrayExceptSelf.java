package com.Leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        productExceptSelfWithLog(new int[]{1, 2, 3, 4});
    }

    private static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 0)
            return nums;

        int[] prod = new int[nums.length];
        Arrays.fill(prod,1);

        int tmp = 1;
        for (int i = 0 ; i < prod.length; i++){
            prod[i] = tmp;
            tmp = tmp * nums[i];
        }

        tmp = 1;
        for (int i = nums.length-1 ; i >= 0; i--){
            prod[i] *= tmp;
            tmp = tmp * nums[i];
        }

        return prod;
    }


    // epsilon value to maintain precision
    static final double EPS = 1e-9;

    private static void productExceptSelfWithLog(int[] a) {
        int n = a.length;
        // to hold sum of all values
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.log10(a[i]);

        // output product for each index
        // anti log to find original product value
        for (int i = 0; i < n; i++)
            System.out.print(
                    (int)(EPS
                            + Math.pow(
                            10.00, sum
                                    - Math.log10(a[i])))
                            + " ");
    }
}
