package com.Leetcode.twopointer;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class MostProfitAssigningWork {
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[]{68, 35, 52, 47, 86}, new int[]{67, 17, 1, 81, 3}, new int[]{92, 10, 85, 84, 82}));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Point[] jobs = new Point[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.x));
        Arrays.sort(worker);

        int res = 0;

        for (int i = 0 ; i < worker.length; i++) {
            int cnt = 1;
            while (i < worker.length-1 && worker[i+1] == worker[i]) {
                cnt++;
                i++;
            }

            int profitVal = (worker[i] >= jobs[0].x) ?
                    getProfitValue(worker[i], jobs) :
                    0;
            res += cnt*profitVal;
        }

        return res;
    }

    private static int getProfitValue(int ability, Point[] jobs) {
        int l = 0, r = jobs.length-1, mid = -1;

        if (jobs[r].x < ability) {
            return jobs[r].y;
        }

        while (l < r) {
            mid = l + (r-l)/2;
            if (jobs[mid].x <= ability)
                l++;
            else
                r--;
        }

        return jobs[mid].y;
    }
}
