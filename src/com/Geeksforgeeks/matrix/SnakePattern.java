package com.Geeksforgeeks.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SnakePattern {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            int arr[][] = new int[n][n];

            int j = 0;
            for (int i = 0; i < n * n; i++) {
                if (i > 0 && i % n == 0) {
                    j++;
                }
                arr[j][i % n] = ar[i];
            }

            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (j = 0; j < n; j++) {
                        str.append(arr[i][j]).append(" ");
                    }
                } else {
                    for (j = n - 1; j >= 0; j--) {
                        str.append(arr[i][j]).append(" ");
                    }
                }
            }
            System.out.println(str);
        }
    }
}
