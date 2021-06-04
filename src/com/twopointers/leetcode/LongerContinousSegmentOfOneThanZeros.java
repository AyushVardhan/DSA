package com.twopointers.leetcode;

public class LongerContinousSegmentOfOneThanZeros {

    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1101"));
    }

    private static boolean checkZeroOnes(String s) {
        return countMaxContinous(1, s) > countMaxContinous(0, s);
    }

    private static int countMaxContinous(int num, String str) {
        char[] chrs = str.toCharArray();
        int cnt = 0, res = 0;

        for (char chr : chrs) {
            if (Character.getNumericValue(chr) == num) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 0;
            }
        }

        return res;
    }
}
