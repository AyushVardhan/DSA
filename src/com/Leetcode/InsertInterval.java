package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10, 12}, {15, 18}, {20, 25}};
        int[] merge = new int[]{16, 19};
        insert(arr, merge);
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length <= 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        int startOfRange = newInterval[0];
        int endOfRange = newInterval[1];

        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            startOfRange = Math.min(startOfRange,intervals[i][0]);
            endOfRange = Math.max(endOfRange,intervals[i][1]);
            i++;
        }

        result.add(new int[]{startOfRange,endOfRange});

        while (i < intervals.length){
            result.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        return result.toArray(new int[result.size()][2]);
    }

//   WHY TO SORT AGAIN IF INPUT IS ALREADY SORTED???
//    private static int[][] solveBySorting(int[][] intervals, int[] newInterval){
//        Stack<int[]> stack = new Stack<>();
//
//        int[][] tmpArr = new int[intervals.length+1][2];
//        for (int i = 0; i < intervals.length; i++){
//            tmpArr[i][0]=intervals[i][0];
//            tmpArr[i][1]=intervals[i][1];
//        }
//        tmpArr[intervals.length][0] = newInterval[0];
//        tmpArr[intervals.length][1] = newInterval[1];
//
//        Arrays.sort(tmpArr, Comparator.comparingInt(t -> t[0]));
//
//        stack.push(tmpArr[0]);
//        for (int i = 1; i < tmpArr.length; i++){
//            int[] topItem = stack.peek();
//            if (tmpArr[i][0] <= topItem[1]){
//                topItem[1] = Math.max(tmpArr[i][1],topItem[1]);
//                stack.pop();
//                stack.push(topItem);
//            }else {
//                stack.push(tmpArr[i]);
//            }
//        }
//
//        int[][] arr = new int[stack.size()][2];
//        int i = 0;
//        while (!stack.isEmpty()) {
//            int[] popData = stack.pop();
//            arr[i][0] = popData[0];
//            arr[i][1] = popData[1];
//            i++;
//        }
//        Arrays.sort(arr, Comparator.comparingInt(t->t[0]));
//        return arr;
//    }

}
