package com.programming.graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int x = numIslands(grid);
        System.out.println(x);
    }

    private static int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    markIsland(grid, vis, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void markIsland(char[][] grid, boolean[][] vis, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0' || vis[i][j])
            return;

        vis[i][j] = true;
        markIsland(grid, vis, i + 1, j);
        markIsland(grid, vis, i - 1, j);
        markIsland(grid, vis, i, j + 1);

    }
}
