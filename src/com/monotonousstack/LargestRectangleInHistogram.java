package com.monotonousstack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    private static int largestRectangleArea(int[] heights) {
        if (heights.length <= 0)
            return 0;

        int n = heights.length;
        int i = 0, tmpArea = 0, res = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < n) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);
            else {
                int top = stack.peek();
                stack.pop();

                tmpArea = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                res = Math.max(res, tmpArea);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();

            tmpArea = heights[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            res = Math.max(res, tmpArea);
        }

        return res;
    }

//    BRUTE FORCE
//    private static int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int area = 0, res = heights[0];
//
//        for (int i = 0; i < n; i++) {
//            int j = i + 1;
//            if (j < n && heights[j] >= heights[i]) {
//                int k = i;
//                while (j < n && heights[j] >= heights[i]) {
//                    k++;
//                    j++;
//                }
//                area = (k - i + 1) * heights[i];
//            }
//
//            if (i > 0 && heights[i-1]==0) {
//                area = heights[i];
//            }
//
//            if (i > 0) {
//                int idx = i - 1; int k = 0;
//                while (idx >= 0 && heights[idx] >= heights[i]) {
//                    idx--;
//                    k++;
//                }
//                area += k * heights[i] + (area == 0 ? heights[i] : 0);
//            }
//
//            res = Math.max(res, area);
//            area = 0;
//        }
//        return res;
//    }
}
