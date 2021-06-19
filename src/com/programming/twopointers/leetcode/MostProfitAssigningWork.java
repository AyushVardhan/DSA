package com.programming.twopointers.leetcode;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{5, 6, 7, 4}));
    }

    private static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Point[] jobs = new Point[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new Point(difficulty[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(pnt -> pnt.x));
        Arrays.sort(worker);

        int res = 0, max  = 0, j = 0;
        for (int ability : worker) {
            while (j < jobs.length && ability >= jobs[j].x) {
                max = Math.max(max, jobs[j++].y);
            }

            res += max;
        }

        return res;
    }
}
