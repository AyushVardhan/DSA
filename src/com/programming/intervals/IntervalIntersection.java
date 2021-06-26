package com.programming.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] intervalOne = {{1, 3}, {5, 6}, {7, 9}};
        int[][] intervalTwo = {{2, 3}, {5, 7}};

        getIntersection(intervalOne, intervalTwo);
    }

    private static void getIntersection(int[][] intervalOne, int[][] intervalTwo) {
        int i = 0, j = 0;
        List<int[]> resList = new ArrayList<>();

        while (i < intervalOne.length && j < intervalTwo.length) {

            if ((intervalOne[i][0] >= intervalTwo[j][0] && intervalOne[i][0] <= intervalTwo[j][1]) ||
                    ((intervalTwo[j][0] >= intervalOne[i][0] && intervalTwo[j][0] <= intervalOne[i][1]))) {

                resList.add(new int[]{Math.max(intervalOne[i][0], intervalTwo[j][0]), Math.min(intervalOne[i][1], intervalTwo[j][1])});
            }

            if (intervalOne[i][1] < intervalTwo[j][1]) // because it increases the possibility to get another interval
                i++;
            else j++;
        }

        for (int[] interval : resList)
            System.out.println(Arrays.toString(interval));
    }
}
