package com.array;

import java.util.HashSet;
import java.util.Set;


public class SudukoValidation {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {4, 2, 6, 5, 7, 1, 3, 20, 8},
                {8, 5, 7, 2, 9, 3, 1, 4, 6},
                {1, 3, 9, 4, 6, 8, 2, 7, 5},
                {9, 7, 1, 3, 8, 5, 6, 2, 4},
                {5, 4, 3, 7, 2, 6, 8, 1, 9},
                {6, 8, 2, 1, 4, 9, 7, 5, 3},
                {7, 9, 4, 6, 3, 2, 5, 8, 1},
                {2, 6, 5, 8, 1, 4, 9, 3, 7},
                {3, 1, 8, 9, 5, 7, 4, 6, 2}
        };

        System.out.println(solve(matrix));
    }

    private static boolean solve(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> boxSet = new HashSet<>();

        //validate all rows & cols
        for(int rowIdx = 0; rowIdx < 9; rowIdx++) {
            for (int colIdx = 0; colIdx < 9; colIdx++) {

                if (rowSet.contains(matrix[rowIdx][colIdx]) || matrix[rowIdx][colIdx] > 9 || matrix[rowIdx][colIdx] < 0)
                    return false;

                rowSet.add(matrix[rowIdx][colIdx]);

                if (colSet.contains(matrix[colIdx][rowIdx]) || matrix[colIdx][rowIdx] > 9 || matrix[colIdx][rowIdx] < 0)
                    return false;

                colSet.add(matrix[colIdx][rowIdx]);
            }
            rowSet.clear();
            colSet.clear();
        }

        //validate all boxes
        for(int rowIdx = 0; rowIdx < 9; rowIdx = rowIdx + 3) {
            for (int colIdx = 0; colIdx < 9; colIdx = colIdx + 3) {
                for (int i = rowIdx; i < rowIdx+3; i++) {
                    for (int j = colIdx; j < colIdx+3; j++) {
                        if (boxSet.contains(matrix[i][j]) || matrix[i][j] > 9 || matrix[i][j] < 0)
                            return false;
                        boxSet.add(matrix[i][j]);
                    }
                }
                boxSet.clear();
            }
        }

        return true;
    }
}
