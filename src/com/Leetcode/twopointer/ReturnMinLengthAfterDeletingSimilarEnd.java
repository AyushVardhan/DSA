package com.Leetcode.twopointer;

public class ReturnMinLengthAfterDeletingSimilarEnd {
    public static void main(String[] args) {
        System.out.println(minimumLength("aabccabba"));
    }

    private static int minimumLength(String s) {
        char a[] = s.toCharArray();
        int l = 0, r = s.length()-1;

        int res = Integer.MAX_VALUE;

        while (l < r) {
            if (a[l] == a[r]) {

                l++;
                while (l < r && a[l] == a[l-1])
                    l++;

                r--;
                while (l < r && a[r] == a[r+1])
                    r--;

                res = Math.min(res, (r - l + 1));
            } else{
                break;
            }
        }

        return res == Integer.MAX_VALUE ? s.length() : res;
    }
}
