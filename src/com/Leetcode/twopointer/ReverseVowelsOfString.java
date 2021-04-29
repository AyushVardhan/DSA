package com.Leetcode.twopointer;

import java.util.Arrays;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    private static String reverseVowels(String s) {
        int l = 0, r = s.length()-1;
        char[] sc = s.toCharArray();

        while (l < r) {
            char lc = sc[l];
            char rc = sc[r];

            if (!(lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u')) {
                l++;
            } else if (!(rc == 'a' || rc == 'e' || rc == 'i' || rc == 'o' || rc == 'u')) {
                r--;
            } else {
                char tmp = sc[l];
                sc[l] = sc[r];
                sc[r] = tmp;
                l++;
                r--;
            }
        }

        return String.valueOf(sc);
    }
}
