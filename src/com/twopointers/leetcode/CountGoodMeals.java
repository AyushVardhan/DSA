package com.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,2,3,1}));
    }

    private static int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int num : deliciousness)
            max = Math.max(max, num);

        for (int foodDelIdx : deliciousness) {
            int sum = 1;
            for (int i = 0; i <= 21; i++) {
                int diffNeeded = sum - foodDelIdx;
                if (diffNeeded > max)
                    break;
                if (sum >= foodDelIdx && map.containsKey(diffNeeded)) {
                    ans += map.get(sum - foodDelIdx);
                    ans %= MOD;
                }
                sum *= 2;
            }
            map.put(foodDelIdx, map.getOrDefault(foodDelIdx, 0) + 1);
        }

        return ans;
    }
}
