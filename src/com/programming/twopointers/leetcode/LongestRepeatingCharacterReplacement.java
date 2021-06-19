package com.programming.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    private static int characterReplacement(String s, int k) {
        int l = 0, res = 0, maxCnt = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc,0)+1);
            maxCnt = Math.max(maxCnt, map.get(rc));

            if ((r-l+1)-maxCnt > k) {
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc)-1);
            }
            res = Math.max(res, r-l + 1);
        }

        return res;
    }
}