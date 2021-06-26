package com.programming.intervals;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {2,6}, {3,5}};
        getMutuallyExclusiveIntervals(intervals);
    }

    private static void getMutuallyExclusiveIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);


        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= stack.peek()[1]) {
                int[] topElementOnStack = stack.pop();
                int start = Math.min(intervals[i][0], topElementOnStack[0]);
                int end = Math.max(intervals[i][1], topElementOnStack[1]);
                stack.push(new int[]{start, end});
            } else {
                stack.push(intervals[i]);
            }
        }

        for (int[] interval : stack) {
            System.out.print(interval[0]+" "+interval[1] +", ");
        }
    }
}
