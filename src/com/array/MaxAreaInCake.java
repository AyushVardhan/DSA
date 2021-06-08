package com.array;

import java.util.Arrays;

public class MaxAreaInCake {
    public static void main(String[] args) {
        System.out.println(maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }

    private static int maxArea(int hei, int wid, int[] horizontalCuts, int[] verticalCuts) {

        int res = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = Math.max(horizontalCuts[0], hei - horizontalCuts[horizontalCuts.length - 1]);

        int maxW = Math.max(verticalCuts[0], wid - verticalCuts[verticalCuts.length - 1]);

        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            maxH = Math.max(maxH, horizontalCuts[i + 1] - horizontalCuts[i]);
        }

        for (int j = 0; j < verticalCuts.length - 1; j++) {
            maxW = Math.max(maxW, verticalCuts[j + 1] - verticalCuts[j]);
        }

        res = (int) ((long) maxH * maxW % 1000000007);

        return res;
    }
}
