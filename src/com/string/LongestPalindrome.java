package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("baab"));
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2; // move left from start index i
                end = i + len / 2; // move right from index i
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    // DP Approach
    // https://www.youtube.com/watch?v=UflHuQj6MVA
    private static String longestPalindromeDP(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);
            }
        }

        return res;
    }


    //Did not worked
    private static String longestPalindromeOwnApproach(String s) {

        if (null == s || s.length() == 0)
            return s;

        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray())
            set.add(ch);

        if (set.size() == 1)
            return s;

        String res = String.valueOf(s.charAt(0));
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        for (int r = 1; r < s.length(); r++) {

            if (map.containsKey(s.charAt(r))) {
                char c = s.charAt(r);
                if (isPalindrome(s, map.get(c), r)) {
                    if (res.length() < r - map.get(c) + 1)
                        res = s.substring(map.get(c), r + 1);
                }
            }

            map.put(s.charAt(r), r);
        }
        return res;
    }

    private static boolean isPalindrome(String s, int l, int r) {
        String str = s.substring(l, r + 1);
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }

        return true;
    }
}
