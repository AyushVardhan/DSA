package com.Leetcode.slidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printFirstNegativeInteger(new long[]{12, -1, -7, 8, -15, 30, 16, 28}, 8, 3)));
    }

    private static long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] res = new long[N - K + 1];
        Deque<Long> deque = new LinkedList<>();
        int l = 0, itr = 0;

        for (int r = 0; r < A.length; r++) {
            if (A[r] < 0) {
                deque.addLast(A[r]);
            }

            if (r >= K - 1) {
                res[itr++] = deque.isEmpty() ? 0 : deque.peekFirst();

                if (!deque.isEmpty() && A[l] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                l++;
            }
        }

        return res;
    }
}
