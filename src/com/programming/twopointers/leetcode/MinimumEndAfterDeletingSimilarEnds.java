package com.programming.twopointers.leetcode;

public class MinimumEndAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        System.out.println(minimumLength("cabaababac"));
    }

    private static int minimumLength(String s) {
        char[] chrs = s.toCharArray();
        int l = 0, r = chrs.length-1;

        while (l < r && chrs[l] == chrs[r]) {
            while (l < r && chrs[l] == chrs[l+1])
                l++;
            while (l < r && chrs[r-1] == chrs[r])
                r--;

            if (l == r)
                return 0;

            l++;
            r--;
        }

        return r-l+1;
    }
}
