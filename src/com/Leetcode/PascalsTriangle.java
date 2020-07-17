package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    private static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }

        int[][] tmp = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            tmp[i][0] = 1;
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpL = new ArrayList<>();
        tmpL.add(1);
        list.add(tmpL);

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                tmp[i][j] = tmp[i - 1][j - 1] + tmp[i - 1][j];
            }

            List<Integer> tmpList = new ArrayList<>();
            for (int j = 0; j < numRows; j++) {
                if (tmp[i][j] == 0) {
                    break;
                }
                tmpList.add(tmp[i][j]);
            }
            list.add(tmpList);
        }

        return list;
    }
}
