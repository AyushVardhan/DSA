package com.programming.twopointers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersection {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(intervalIntersection(new int[][]{{0, 2}, {5, 10}}, new int[][]{{1, 5}, {8, 12}})));
    }

    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);

            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            if (firstList[i][1] < secondList[j][1])
                i++;
            else j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
