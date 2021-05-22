package com.twopointers.leetcode;

import java.util.Arrays;

//        Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and
//        arr[i] + arr[j] + arr[k] == target.
//
//        As the answer can be very large, return it modulo 109 + 7.


public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }

    private static int threeSumMulti(int[] A, int target) {
        int MOD = 1000000007;
        int ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length-2; i++) {
            int T = target - A[i];
            int j = i + 1, k = A.length - 1;

            while (j < k) {
                if (A[j] + A[k] < T)
                    j++;
                else if (A[j] + A[k] > T)
                    k--;
                else if (A[j] == A[k]) {
                    // We have A[j] + A[k] == T.
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    int len = k - j;
                    int possibilities = ((len) * (len + 1)) / 2;
                    ans = (ans + possibilities) % MOD;
                    break;
                } else { // We have A[j] + A[k] == T.
                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j+1]) {
                        left++;
                        j++;
                    }
                    while (k-1 > j && A[k] == A[k-1]) {
                        right++;
                        k--;
                    }

                    ans = (ans + (left * right)) % MOD;
                    j++;
                    k--;
                }
            }
        }

        return ans % MOD;
    }
}
