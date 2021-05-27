package com.twopointers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VisiblePoints {
    public static void main(String[] args) {
        List<List<Integer>> points =  new ArrayList<>();
        points.add(Arrays.asList(-1,2));
        points.add(Arrays.asList(2,1));
        points.add(Arrays.asList(-2,2));
        points.add(Arrays.asList(3,3));
        System.out.println(visiblePoints(points, 90, Arrays.asList(1,1)));
    }

    private static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }

}
