package com.programming.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMeetingRooms {
    public static void main(String[] args) {
        System.out.println(getMinRooms(new int[][]{{4,5},{2,3},{2,4},{3,5}}));
    }

    private static int getMinRooms(int[][] schedule) {
        List<Integer> startTimeList = new ArrayList<>();
        List<Integer> endTimeList = new ArrayList<>();

        for (int[] timing : schedule){
            startTimeList.add(timing[0]);
            endTimeList.add(timing[1]);
        }

        Collections.sort(startTimeList);
        Collections.sort(endTimeList);

        int res = 0;
        int tmp = 1;
        int i = 1;
        int j = 0;

        while (i < startTimeList.size() && j < endTimeList.size()) {
            if (startTimeList.get(i) < endTimeList.get(j)) {
                tmp++;
                i++;
            } else {
                tmp--;
                j++;
            }
            res = Math.max(tmp, res);
        }

        return res;
    }
}
