package com.maths;

public class DetermineForTargetMatrixByRotation {
    public static void main(String[] args) {
        System.out.println(findRotation(new int[][]{{0,1},{1,0}}, new int[][]{{1,0},{1,0}}));
    }

    private static boolean findRotation(int[][] mat, int[][] target) {
        int rows = mat.length, cols = mat[0].length;
        for (int i = 0; i <= rows * cols - 1; i++) {
            rotate(mat);
            if (equal(mat, target))
                return true;
        }

        return false;
    }

    private static void rotate(int[][] mat) {
        int rows = mat.length, cols = mat[0].length, N = rows;

        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    private static boolean equal(int[][] mat, int[][] target) {
        int rows = mat.length, cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }

        return true;
    }
}
