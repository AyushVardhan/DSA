package com.Leetcode;

public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 2, 5}, {3, 2, 1}}));
    }

    private static int minPathSum(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }

        sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j],dp[i][j - 1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
