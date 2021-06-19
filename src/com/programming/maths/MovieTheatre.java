package com.programming.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

Given a list of time exclusive intervals for different movie showings (possibly overlapping),
find the minimum number of theatres required to be able to show all movies.

Approach :
    1. Keep arrival/start time in one array :: startArr. And sort it out.
    2. Keep departure/end time in another array :: endArr. And sort it out.
    3. If my idx at startArr is 1 and idx at endArr is 0, then I'll need at-least 1 theatre to run shows. So start with it.
    4. Now if, startArr[startIdx] >= endArr[endIdx], then it means i can vacate the theatre/area as next start is not conflicting.
    5. Or if, startArr[startIdx] < endArr[endIdx], then I'll need another theatre to run show palely.
    6. Same approach is followed below using a counter & recording the maxCount needed which checking the required theatres.

 */

public class MovieTheatre {
    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{30,75}, {0,50}, {60,150}}));
    }

    private static int solve(int[][] intervals) {
        if (intervals.length == 1)
            return 1;

        if (intervals.length == 0)
            return 0;

        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        for (int[] slot : intervals) {
            startTimes.add(slot[0]);
            endTimes.add(slot[1]);
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int tempCount = 1,resCount = 1;
        int startTimeIdx = 1, endTimeIdx = 0, size = intervals.length;

        while (startTimeIdx < size && endTimeIdx < size) {
            if (startTimes.get(startTimeIdx) < endTimes.get(endTimeIdx)) {
                startTimeIdx++;
                tempCount++;
            } else {
                endTimeIdx++;
                tempCount--;
            }

            resCount = Math.max(resCount, tempCount);
        }

        return resCount;
    }
}
