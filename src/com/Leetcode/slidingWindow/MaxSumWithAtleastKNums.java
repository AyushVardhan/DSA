package com.Leetcode.slidingWindow;


//Given an array and a number k, find the largest sum of the subarray containing at least k numbers. It may be assumed that the size of array is at-least k.
//Input :
//        n = 4
//        arr[] = {-4, -2, 1, -3}
//        k = 2
//Output :
//        -1
//        Explanation :
//        The sub array is {-2, 1}

public class MaxSumWithAtleastKNums {
    public static void main(String[] args) {
        System.out.println(maxSumWithK(new int[]{1,2,3,4,5}, 5, 2));
    }

    static int maxSumWithK(int a[], int n, int k)
    {
        // maxSum[i] is going to store maximum sum
        // till index i such that a[i] is part of the
        // sum.
        int maxSum[] = new int [n];
        maxSum[0] = a[0];

        // We use Kadane's algorithm to fill maxSum[]
        // Below code is taken from method 3 of
        // https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
        int curr_max = a[0];
        for (int i = 1; i < n; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            maxSum[i] = curr_max;
        }

        // Sum of first k elements
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += a[i];

        // Use the concept of sliding window
        int result = sum;
        for (int i = k; i < n; i++)
        {
            // Compute sum of k elements ending
            // with a[i].
            sum = sum + a[i] - a[i-k];

            // Update result if required
            result = Math.max(result, sum);

            // Include maximum sum till [i-k] also
            // if it increases overall max.
            result = Math.max(result, sum + maxSum[i-k]);
        }
        return result;
    }
}