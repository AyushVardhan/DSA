package com.Leetcode;

import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    private static int uniquePaths(int m, int n) {
        int[][] memory = new int[m+1][n+1];
        Arrays.stream(memory).forEach(a -> Arrays.fill(a, -1));
        return uniquePathUtil(m, n, memory);
    }

    private static int uniquePathUtil(int m, int n, int[][] memory) {
        if (m == 1 || n == 1)
            return 1;

        if (memory[m][n] != -1)
            return memory[m][n];

        return memory[m][n] = uniquePathUtil(m - 1, n, memory) + uniquePathUtil(m, n - 1, memory);
    }
}
