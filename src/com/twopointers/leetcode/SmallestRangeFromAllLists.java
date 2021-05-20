package com.twopointers.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeFromAllLists {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestRange(Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20), Arrays.asList(5, 19, 22, 30)))));
    }

    private static int[] smallestRange(List<List<Integer>> nums) {
        int[] result = new int[nums.size()];

        int max = Integer.MIN_VALUE, minx = 0, miny = Integer.MAX_VALUE;
        boolean flag = true;

        PriorityQueue<Integer> queueMin = new PriorityQueue<>(Comparator.comparingInt(x -> nums.get(x).get(result[x])));

        for (int i = 0; i < nums.size(); i++) {
            queueMin.offer(i);
            max = Math.max(max, nums.get(i).get(result[i]));
        }

        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int min_que = queueMin.poll();
                if (miny - minx > max - nums.get(min_que).get(result[min_que])) {
                    minx = nums.get(min_que).get(result[min_que]);
                    miny = max;
                }

                result[min_que]++;
                if (result[min_que] == nums.get(min_que).size()) {
                    flag = false;
                    break;
                }
                queueMin.offer(min_que);
                max = Math.max(max, nums.get(min_que).get(result[min_que]));
            }
        }

        return new int[] {minx, miny};
    }
}
