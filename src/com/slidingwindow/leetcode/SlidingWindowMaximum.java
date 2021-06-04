package com.slidingwindow.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dequeue = new LinkedList<>();
        int[] result = new int[nums.length -k + 1];
        int itr = 0, s = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!dequeue.isEmpty() && dequeue.peekLast() < nums[i]) {
                dequeue.pollLast();
            }
            dequeue.addLast(nums[i]);

            if (i >= k-1){
                result[itr++] = dequeue.peekFirst();

                if (nums[s++] == dequeue.peekFirst()){
                    dequeue.removeFirst();
                }
            }
        }

        return result;
    }
}
