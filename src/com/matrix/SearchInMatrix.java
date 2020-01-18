package com.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());
        while (tests-- > 0) {
            String[] s = br.readLine().trim().split("\\s+");
            int rows = Integer.parseInt(s[0]);
            int cols = Integer.parseInt(s[1]);
            s = br.readLine().trim().split("\\s+");
            int k = 0;
            int[][] arr = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = Integer.parseInt(s[k++]);
                }
            }

            int x = Integer.parseInt(br.readLine().trim());

            int opt = 0;
            for (int i = 0; i < rows; i++) {
                if (arr[i][0] <= x && arr[i][cols - 1] >= x) {
                    opt = getVal(arr, i, cols, x);
                }
            }

            System.out.println(opt);
        }
    }

    private static int getVal(int[][] arr, int i, int cols, int x) {
        int l = 0, mid = 0;
        int r = cols - 1;
        while (l <= r) {
            mid = (int) Math.ceil((l + r) >> 1);
            if (arr[i][mid] == x) {
                return 1;
            } else if (arr[i][mid] > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}
