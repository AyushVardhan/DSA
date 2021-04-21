package com.Leetcode.slidingWindow;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueOfEquation {
    public static void main(String[] args) {
        System.out.println(findMaxValueOfEquation(new int[][]{{1,3},{2,0},{5,10},{6,-10}}, 1));
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Pair<Integer, Integer>> ms = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
                ms.pollFirst();
            }
            if (!ms.isEmpty()) {
                res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
            }
            while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
                ms.pollLast();
            }
            ms.offerLast(new Pair<>(point[1] - point[0], point[0]));
        }
        return res;
    }
}
