package com;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinderFromStream {
    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        System.out.println(findMedian());
        addNum(3);
        System.out.println(findMedian());
    }

    static PriorityQueue<Integer> right = new PriorityQueue<>(), left = new PriorityQueue<>(Collections.reverseOrder());

    private static void addNum(int num) {
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    private static double findMedian() {
        if (left.size() == right.size())
            return (left.peek() + right.peek()) / 2.0;
        else
            return left.peek();
    }
}
