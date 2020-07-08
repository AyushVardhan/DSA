package com.Geeksforgeeks.recursion;

import java.util.Scanner;

public class FloodFillAlgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();

        while (tests-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();
            int arr[][] = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            int x = in.nextInt();
            int y = in.nextInt();
            int k = in.nextInt();
            int c = arr[x][y];

            colorScreen(arr, x, y, k, c, N, M);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void colorScreen(int[][] arr, int x, int y, int k, int c, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m || arr[x][y] == k || arr[x][y] != c)
            return;

        arr[x][y] = k;
        colorScreen(arr, x + 1, y, k, c, n, m);
        colorScreen(arr, x - 1, y, k, c, n, m);
        colorScreen(arr, x, y + 1, k, c, n, m);
        colorScreen(arr, x, y - 1, k, c, n, m);
    }
}
