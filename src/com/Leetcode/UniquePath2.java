package com.Leetcode;

public class UniquePath2 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length <= 0 || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean obstacle = false;

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacle || obstacleGrid[0][i] == 1) {
                obstacle = true;
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        obstacle = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacle || obstacleGrid[i][0] == 1) {
                obstacle = true;
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
