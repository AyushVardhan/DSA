package com.Leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrayWithSum {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int x: P) {
            ans += count.getOrDefault(x, 0);
            count.put(x+S, count.getOrDefault(x+S, 0) + 1);
        }

        return ans;
    }
}
