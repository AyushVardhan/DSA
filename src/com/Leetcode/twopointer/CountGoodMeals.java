package com.Leetcode.twopointer;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,3,5,7,9}));
    }

    public static int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>(); // key: num, val: ocurrence
        int length = deliciousness.length, answer = 0, MOD = 1000000007;

        for (int num : deliciousness) {
            int sum = 1;
            for (int i = 0; i <= 21; i++) {// 21 because 2^20 + 2^20 = 2^21, this is largest sum we can obtain in this problem.
                if (sum >= num && map.containsKey(sum - num)) {
                    answer += map.get(sum - num);
                    answer %= MOD;
                }
                sum *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int)answer;
    }
}
