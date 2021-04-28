package com.Leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Practise {
    public static void main(String[] args) {
        System.out.println(countDistinct("aabbba", 3));

    }

    private static int countDistinct(String str, int k) {
        int len = getLen(str);
        int res = Integer.MIN_VALUE;

        for (int unique = 1; unique <= len; unique++) {
            int l = 0, r = 0, idx, cntUnique = 0, cntWithK = 0;
            int[] map = new int[26];

            while (r < str.length()) {
                if (cntUnique <= unique) {
                    idx = str.charAt(r) - 'a';
                    if (map[idx] == 0) cntUnique++;
                    map[idx]++;
                    if (map[idx] == k) cntWithK++;
                    r++;
                } else {
                    idx = str.charAt(l) - 'a';
                    if (map[idx] == k) cntWithK--;
                    map[idx]--;
                    if (map[idx] == 0) cntUnique--;
                    l++;
                }
            }

            if (unique == cntUnique && cntUnique == cntWithK)
                res = Math.max(res, r - l);
        }

        return res;
    }

    private static int getLen(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        return map.size();
    }
}
