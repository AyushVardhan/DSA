package com.Leetcode;

public class RotateImage {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(arr);
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++){
            for (int j = i; j < n - 1 -i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }

        System.out.println("[");
        for (int i = 0; i < n; i++){
            System.out.print("[");
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.print("],");
            System.out.println();
        }
        System.out.println("]");
    }
}
