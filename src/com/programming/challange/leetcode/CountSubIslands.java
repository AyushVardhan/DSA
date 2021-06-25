package com.programming.challange.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CountSubIslands {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands(grid1, grid2));
    }

    private static int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        int count = 0;

        for (int r = 0; r < grid2.length; r++) {
            for (int c = 0; c < grid2[0].length; c++) {
                if (!visited[r][c] && grid2[r][c] == 1) {
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    dfs(grid2, visited, r, c, list);

                    int counter = 0;
                    for (Pair<Integer, Integer> islandCoordinate : list) {
                        if (grid1[islandCoordinate.getKey()][islandCoordinate.getValue()] == 1) {
                            counter++;
                        }
                    }

                    if (counter == list.size())
                        count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] grid2, boolean[][] visited, int r, int c, List<Pair<Integer, Integer>> list) {

        if (r >= grid2.length || r < 0 || c >= grid2[0].length || c < 0 || visited[r][c] || grid2[r][c] == 0)
            return;

        list.add(new Pair<>(r, c));
        visited[r][c] = true;
        dfs(grid2, visited, r + 1, c, list);
        dfs(grid2, visited, r - 1, c, list);
        dfs(grid2, visited, r, c + 1, list);
        dfs(grid2, visited, r, c - 1, list);
    }
}
