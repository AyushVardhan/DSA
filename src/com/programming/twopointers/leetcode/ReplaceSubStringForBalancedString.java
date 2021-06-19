package com.programming.twopointers.leetcode;

public class ReplaceSubStringForBalancedString {
    public static void main(String[] args) {
        System.out.println(balancedString("QWER"));
    }

    private static int balancedString(String s) {
        int[] map = new int[26];
        int l = 0, k = s.length()/4, res = s.length();

        for (char c : s.toCharArray())
            map[c-'A']++;

        for (int r = 0; r < s.length(); r++) {
            --map[s.charAt(r)-'A'];
            while (l < s.length() && map['Q'-'A'] <= k && map['W'-'A'] <= k && map['E'-'A'] <= k && map['R'-'A'] <= k) {
                res = Math.min(r - l + 1, res);
                ++map[s.charAt(l++)-'A'];
            }
        }

        return res;
    }
}
