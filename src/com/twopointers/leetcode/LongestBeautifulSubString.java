package com.twopointers.leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestBeautifulSubString {
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aaaaeiouaaaaaeiou"));
    }

    private static int longestBeautifulSubstring(String word) {
        List<Character> list = Arrays.asList('a','e','i','o','u');
        char[] chrs = word.toCharArray();
        int n = chrs.length, r = 0, j = 0, l = 0, res = 0;

        if (n == 0)
            return 0;

        while (r < n) {
            while (j < list.size() && r < n && chrs[r] == list.get(j)) {
                while (r+1 < n && chrs[r] == chrs[r+1])
                    r++;
                j++;
                r++;
            }

            if (j == list.size()) {
                res = Math.max(res, r-l);
            }

            j = 0;
            if (r < n && list.get(j) != chrs[r]) r++;
            l = r;
        }

        return res;
    }
}
