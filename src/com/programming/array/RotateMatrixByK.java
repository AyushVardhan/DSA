package com.programming.array;

import java.util.Arrays;

public class RotateMatrixByK {
    public static void main(String[] args) {
        int[][] arr = {{40, 10}, {30, 20}};
        System.out.println(Arrays.deepToString(rotateGrid(arr, 1)));
    }

    private static int[][] rotateGrid(int[][] grid, int k) {
        int bottom = grid.length - 1;
        int right = grid[0].length - 1;
        int top = 0;
        int left = 0;

        while (bottom > top && right > left) {
            int totalElementsInLayer = ((bottom - top + 1) * 2 + (right - left + 1) * 2) - 4;
            int times = k % totalElementsInLayer;

            while (times-- > 0) {
                int temp = grid[top][left];

                for (int i = left; i < right; i++) {
                    grid[top][i] = grid[top][i + 1];
                }

                for (int i = top; i < bottom; i++) {
                    grid[i][right] = grid[i + 1][right];
                }

                for (int i = right; i > left; i--) {
                    grid[bottom][i] = grid[bottom][i - 1];
                }

                for (int i = bottom; i > top; i--) {
                    grid[i][left] = grid[i - 1][left];
                }

                grid[top + 1][left] = temp;
            }
            top++;
            left++;
            right--;
            bottom--;
        }

        return grid;
    }
}
