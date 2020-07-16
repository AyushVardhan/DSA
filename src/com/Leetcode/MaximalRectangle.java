package com.Leetcode;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));
    }

    private static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 ||matrix[0].length == 0) {
            return 0;
        }
        final int M = matrix.length;
        final int N = matrix[0].length;
        int[][] dp = new int[M][N];
        int output = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && matrix[i][j] == '1') {
                    dp[i][j] = 1;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            output = Math.max(output, largestRectangleArea(dp[i]));
        }
        return output;
    }

    private static int largestRectangleArea(int[] heights) {
        int max_area = 0, tmpArea = 0, i = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();

        while (i < n) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.peek();
                stack.pop();

                tmpArea = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if (tmpArea > max_area)
                    max_area = tmpArea;
            }
        }

        while (!stack.isEmpty()){
            int top = stack.peek();
            stack.pop();

            tmpArea = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if (tmpArea > max_area)
                max_area = tmpArea;
        }

        return max_area;
    }
}
