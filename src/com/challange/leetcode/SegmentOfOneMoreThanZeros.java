package com.challange.leetcode;

public class SegmentOfOneMoreThanZeros {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("111000"));
    }

    public static boolean checkZeroOnes(String s) {
        return getCount(s,'1') > getCount(s,'0');
    }

    private static int getCount(String s, char c) {
        int oneCount = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == c) {
                oneCount++;
            } else {
                oneCount = 0;
            }
            res = Math.max(res, oneCount);
        }

        return res;
    }
}
