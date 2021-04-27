package com.Leetcode.slidingWindow;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class Practise {
    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{10, -5, -2, 4, 0, 3}, 3));

    }

    private static int countDistinct(int[] arr, int k) {

        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        Deque<Pair<Integer, Integer>> deque = new LinkedList<>();
        deque.add(new Pair<>(arr[0],0));

        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i] + deque.peekFirst().getKey();

            while (deque.size() > 0 && deque.peekLast().getKey() < dp[i])
                deque.pollLast();

            deque.addLast(new Pair<>(dp[i],i));

            if (i - k == deque.peekFirst().getValue())
                deque.pollFirst();
        }

        return dp[arr.length-1];
    }
}
