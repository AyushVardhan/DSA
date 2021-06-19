package com.programming.stack;

import java.util.*;

public class IntervalUnion {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solveStack(new int[][]{{2,3},{0, 4}, {0, 1}})));
    }

    private static int[][] solveStack(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));

        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{intervals[0][0],intervals[0][1]});

        for (int i = 1; i < intervals.length; i++){
            int[] topRange = stack.peek();

            if (intervals[i][0] > topRange[1]){
                stack.push(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                topRange[1] = Math.max(intervals[i][1],topRange[1]);
                stack.pop();
                stack.push(topRange);
            }
        }

        int[][] result = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()){
            int[] popRes = stack.pop();
            result[i][0] = popRes[0];
            result[i][1] = popRes[1];
            i++;
        }
        return result;
    }

    private static int[][] solve(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> resList = new ArrayList<>();

        int i = 0, j = 1;
        int len = intervals.length;

        while (j < len) {
            while (j < len && intervals[i][1] < intervals[j][0]) {
                resList.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
                j++;
            }

            if (j >= len)
                break;

            int minSt = intervals[j][0], minEd = intervals[i][1];
            while (j < len && minEd >= intervals[j][0]) {
                minSt = Math.min(intervals[i][0], minSt);
                minEd = Math.max(intervals[j][1], minEd);
                i++;
                j++;
            }

            resList.add(new int[]{minSt, minEd});

            i = j;
            j = j + 1;
        }

        while (i < len) {
            resList.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int[][] res = new int[resList.size()][2];
        for (int k = 0; k < resList.size(); k++) {
            res[k][0] = resList.get(k)[0];
            res[k][1] = resList.get(k)[1];
        }

        return res;
    }
}
