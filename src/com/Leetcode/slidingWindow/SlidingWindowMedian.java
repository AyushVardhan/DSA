package com.Leetcode.slidingWindow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        double[] x = medianSlidingWindow(new int[]{1,4,2,3}, 3);
        System.out.println(x);
    }


    public static double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        Supplier<Double> median = (k % 2 == 0) ?
                () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
                () -> (double) nums[right.first()];

        // balance lefts size and rights size (if not equal then right will be larger by one)
        Runnable balance = () -> {
            while (left.size() > right.size()) {
                right.add(left.pollFirst());
            }
        };

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) left.add(i);
        balance.run(); result[0] = median.get();

        for (int i = k, r = 1; i < nums.length; i++, r++) {
            // remove tail of window from either left or right
            if(!left.remove(i - k)) {
                right.remove(i - k);
            }

            // add next num, this will always increase left size
            right.add(i);

            left.add(right.pollFirst());

            // rebalance left and right, then get median from them
            balance.run();

            result[r] = median.get();
        }

        return result;
    }

//    public static double[] medianSlidingWindow(int[] nums, int k) {
//        double[] res = new double[nums.length - k + 1];
//        ArrayList<Integer> list = new ArrayList<>();
//        int itr = 0; int s = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            list.add(nums[i]);
//
//            if (i >= k-1) {
//                Collections.sort(list);
//                res[itr++] = k % 2 == 0 ? getEvenMedian(list) : getOddMedian(list);
//                list.remove(list.indexOf(nums[s++]));
//            }
//        }
//
//        return res;
//    }

    private static double getEvenMedian(ArrayList<Integer> list) {
        int nextToMid = list.size()/2;
        int prevToMid = nextToMid-1;
        BigDecimal val1 = new BigDecimal(String.valueOf(list.get(nextToMid)));
        BigDecimal val2 = new BigDecimal(String.valueOf(list.get(prevToMid)));
        BigDecimal add = val1.add(val2);
        BigDecimal res = new BigDecimal(String.valueOf(add.divide(new BigDecimal(String.valueOf(2)))));
        return res.doubleValue();
    }

    private static double getOddMedian(ArrayList<Integer> list) {
        int mid = list.size()/2;
        return list.get(mid);
    }
}
