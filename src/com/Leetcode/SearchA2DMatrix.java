package com.Leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 63));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0 ||
                target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0])
            return false;

        if (target == matrix[matrix.length - 1][matrix[0].length - 1] || target == matrix[0][0])
            return true;

        int row = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                row = i;
                break;
            }
        }

        if (row != -1) {
            int[] dataSet = matrix[row];
            int l = 0, r = dataSet.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (dataSet[mid] == target) {
                    return true;
                } else if (dataSet[mid] > target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return false;
    }
}
