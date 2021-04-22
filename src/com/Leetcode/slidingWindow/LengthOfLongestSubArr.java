package com.Leetcode.slidingWindow;

public class LengthOfLongestSubArr {

    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6}, 17, 15));
    }

    public static int lenOfLongSubarr (int A[], int N, int K) {
        int sum = 0, l = 0, res = Integer.MIN_VALUE;

        for (int r = 0; r < N; r++) {
            sum += A[r];

            if (sum == K) {
                res = Math.max(res, r-l+1);
            }

            while (sum > K){
                sum = sum - (A[l] < 0 ? (-A[l]) : A[l]);
                l++;
            }

            if (sum == K) {
                res = Math.max(res, r-l+1);
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
