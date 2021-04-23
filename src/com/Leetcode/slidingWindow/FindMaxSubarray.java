package com.Leetcode.slidingWindow;

public class FindMaxSubarray {
    public static void main(String[] args) {
        System.out.println(findMaxSubarraySum(new long[]{1, 2, 3, 4, 5}, 5, 11));
    }

    static long findMaxSubarraySum(long arr[], int N,int X)
    {
        int l = 0;
        long sum = 0, res = 0;
        for (int r = 0; r < arr.length; r++){
            sum += arr[r];

            while (sum > X) {
                sum -= arr[l++];
            }

            res = Math.max(res,sum);
        }

        return res;
    }
}
