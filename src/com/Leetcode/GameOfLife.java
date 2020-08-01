package com.Leetcode;

import java.util.*;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    private static void gameOfLife(int[][] board) {
        if (board.length <= 0 || board[0].length<=0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        Set<int[]> zeroIndexList = new HashSet<>();
        Set<int[]> oneIndexList = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int neighbourCount = getNeighbourCount(board, i, j);

                if (board[i][j] == 0) {
                    if (neighbourCount == 3){
                        oneIndexList.add(new int[]{i,j});
                    }
                } else {
                    if (neighbourCount < 2 || neighbourCount > 3){
                        zeroIndexList.add(new int[]{i,j});
                    }else {
                        oneIndexList.add(new int[]{i,j});
                    }
                }

            }
        }

        for (int[] next : zeroIndexList) {
            board[next[0]][next[1]] = 0;
        }

        for (int[] next : oneIndexList) {
            board[next[0]][next[1]] = 1;
        }
    }

    private static int getNeighbourCount(int[][] board, int i, int j) {
        int[] x = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
        int[] y = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        int row = board.length;
        int col = board[0].length;
        int count = 0;

        for (int k = 0; k < 8; k++) {
            if (i + x[k] >= 0 && i + x[k] < row && j + y[k] >= 0 && j + y[k] < col && board[i + x[k]][j + y[k]]==1) {
                count++;
            }
        }

        return count;
    }
}
