package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 4}, {2, 3},{2,4}};

        merge(arr);
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{intervals[0][0],intervals[0][1]});

        for (int i = 1; i < intervals.length; i++){
            int[] topRange = stack.peek();

            if (intervals[i][0] > topRange[1]){
                stack.push(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                topRange[1] = Math.max(intervals[i][1],topRange[1]);
                stack.pop();
                stack.push(topRange);
            }
        }

        int[][] result = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()){
            int[] popRes = stack.pop();
            result[i][0] = popRes[0];
            result[i][1] = popRes[1];
            i++;
        }
        return result;
    }

    private static void printArray(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }
}
