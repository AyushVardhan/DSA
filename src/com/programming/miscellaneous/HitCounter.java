package com.programming.miscellaneous;

import java.util.ArrayDeque;
import java.util.Queue;

public class HitCounter {

    public static void main(String[] args) {
        add(0);
        add(60);
        add(60);
        System.out.println(count(70));

    }

    private static Queue<Integer> q = new ArrayDeque<>();

    public HitCounter() {
    }

    private static void add(int timestamp) {
        q.add(timestamp);
    }

    private static int count(int timestamp) {
        while (!q.isEmpty() && timestamp - q.peek() > 60) q.poll();
        return q.size();
    }
}
