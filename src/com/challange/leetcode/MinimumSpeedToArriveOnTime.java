package com.challange.leetcode;

import java.util.Arrays;

public class MinimumSpeedToArriveOnTime {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1,3,2}, 2.7));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length-1)
            return -1;

        int totalDist = 0;
        int maxValue = 0;
        for (int dis : dist) {
            totalDist += dis;
            maxValue = Math.max(maxValue, dis);
        }

        double reqSpeed = totalDist/hour;
        double maxSpeed = maxValue;

        return (int) Math.ceil(reqSpeed);
    }
}
