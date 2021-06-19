package com.programming.deque;

/*

You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside
the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited
in the array.

Return the maximum score you can get.

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameVi {

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }

    private static int maxResult(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>(); // store index of `nums` elements, elements is in decreasing order, the front is the maximum element.

        dq.offer(0);

        for (int i = 1; i < n; ++i) {
            // nums[i] = max(nums[i-k], nums[i-k+1], .., nums[i-1]) + nums[i] = nums[dq.front()] + nums[i]
            nums[i] = nums[dq.peekFirst()] + nums[i];

            // Add nums[i] to our deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast(); // Eliminate elements less or equal to nums[i]

            dq.offerLast(i);

            // Pop if index out of the window size k
            if (i - dq.peekFirst() >= k)
                dq.pollFirst();
        }

        return nums[n - 1];
    }

    private static int maxResultNaiveDp(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; ++i)
            for (int j = Math.max(0, i - k); j < i; ++j)
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);

        return dp[n - 1];
    }
}
