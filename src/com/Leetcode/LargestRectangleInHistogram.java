package com.Leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{3, 4, 5, 1, 5, 4, 3}));
    }

    private static int largestRectangleArea(int[] heights) {
        if (heights.length <= 0)
            return 0;

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
