package com.matrix;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class IsSudukoValid {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int n = 9;
            int arr[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            int flag = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isValid(arr, i, j)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }

            System.out.println(flag == 1 ? 0 : 1);
        }
    }

    private static boolean isValid(int[][] arr, int row, int col) {
        return isValidRow(arr, row) && isValidCol(arr, col) && isValidMatrix(arr, row - row % 3, col - col % 3);
    }

    private static boolean isValidMatrix(int[][] arr, int row, int col) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = arr[i + row][j + col];
                if (set.contains(num)) {
                    return false;
                }

                if (num != 0) {
                    set.add(num);
                }
            }
        }
        return true;
    }

    private static boolean isValidCol(int[][] arr, int col) {
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (colSet.contains(arr[i][col])) {
                return false;
            }

            if (arr[i][col] != 0) {
                colSet.add(arr[i][col]);
            }
        }
        return true;
    }

    private static boolean isValidRow(int[][] arr, int row) {
        HashSet<Integer> rowSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (rowSet.contains(arr[row][i])) {
                return false;
            }

            if (arr[row][i] != 0) {
                rowSet.add(arr[row][i]);
            }
        }
        return true;
    }
}
