package com.Leetcode.twopointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l<=r){
            char left = s.charAt(l);
            char right = s.charAt(r);

            if (!((left >= 'a' && left <= 'z') || (left >= 'A' && left <= 'Z') || (left >= '0' && left <= '9'))) {
                l++;
                continue;
            }

            if (!((right >= 'a' && right <= 'z') || (right >= 'A' && right <= 'Z') || (right >= '0' && right <= '9'))) {
                r--;
                continue;
            }

            if (!String.valueOf(left).toLowerCase().equals(String.valueOf(right).toLowerCase()))
                return false;

            l++;
            r--;
        }

        return true;
    }
}
