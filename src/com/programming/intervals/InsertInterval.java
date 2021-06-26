package com.programming.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] sortedIntervals = {{2,3},{5,7}};
        int[] newInterval = {8,9};

        insertInterval(sortedIntervals, newInterval);
    }

    private static void insertInterval(int[][] sortedIntervals, int[] newInterval) {

        List<int[]> resList = new ArrayList<>();

        int i = 0;
        while (i < sortedIntervals.length && sortedIntervals[i][1] < newInterval[0]) {
            resList.add(sortedIntervals[i]);
            i++;
        }

        while (i < sortedIntervals.length && sortedIntervals[i][0] < newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], sortedIntervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], sortedIntervals[i][1]);
            i++;
        }

        resList.add(newInterval);

        while (i < sortedIntervals.length) {
            resList.add(sortedIntervals[i]);
            i++;
        }

        for (int[] interval : resList) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
