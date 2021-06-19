package com.programming.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysSum {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }

//    EFFICIENT APPROACH
    private static int numSubarraysWithSum(int[] A, int S) {
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


//    SLIDING WINDOW APPROACH
//
//    private static int numSubarraysWithSum(int[] A, int S) {
//        int curSum = 0, left = 0, right = 0, res = 0;
//
//        while (left < A.length && right < A.length) {
//            curSum += A[right];
//
//            if (curSum < S) {
//                right++;
//            } else if (curSum > S) {
//                left++;
//                right = left;
//                curSum = 0;
//            } else {
//                res++;
//                right++;
//
//                if (right == A.length){
//                    left++;
//                    right = left;
//                    curSum = 0;
//                }
//            }
//        }
//
//        return res;
//    }
}
