package com.slidingwindow.leetcode;

import java.util.Arrays;

public class NumOfSubsequenceSatisfyingCondition {
    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3, 5, 6, 7}, 9));
    }

    private static int numSubseq(int[] A, int target) {
        Arrays.sort(A);

        int l = 0, r = A.length - 1, mod = (int) 1e9 + 7, res = 0;
        int pow[] = new int[A.length];
        pow[0] = 1;

        for (int i = 1; i < A.length; i++) {
            pow[i] = pow[i - 1] * 2 % mod;
        }

        while (l <= r) {
            if (A[l] + A[r] > target)
                r--;
            else {
                res = (res + pow[r - l]) % mod;
                l++;
            }
        }

        return res;
    }
}
