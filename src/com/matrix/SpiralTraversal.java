package com.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpiralTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int m = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());

            int row = 0, col = 0, i = 0, j = 0;

            int arr[][] = new int[m][n];

            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++)
                    arr[k][l] = Integer.parseInt(br.readLine().trim());
            }

            while (row < m && col < n) {
                //Printing 1st row
                for (i = col; i < n; i++) {
                    System.out.print(arr[row][i] + " ");
                }
                row++;

                //Printing last col
                for (i = row; i < m; i++) {
                    System.out.print(arr[i][n - 1] + " ");
                }
                n--;

                //Printing last row
                if (row < m) {
                    for (i = n - 1; i >= col; --i) {
                        System.out.print(arr[m - 1][i] + " ");
                    }
                    m--;
                }

                //Printing first col
                if (col < n) {
                    for (i = m - 1; i >= row; --i) {
                        System.out.print(arr[i][col] + " ");
                    }
                    col++;
                }

            }

            System.out.println();
        }
    }
}
