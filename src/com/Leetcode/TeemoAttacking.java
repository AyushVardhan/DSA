package com.Leetcode;

public class TeemoAttacking {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,2}, 2));
    }

    private static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length <= 0)
            return 0;

        int totalPoisonedTime = 0;

        for (int i = 0; i < timeSeries.length - 1; i++){
            totalPoisonedTime += Math.min(timeSeries[i+1] - timeSeries[i], duration);
        }

        return totalPoisonedTime + duration;
    }
}
