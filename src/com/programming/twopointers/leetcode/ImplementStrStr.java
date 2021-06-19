package com.programming.twopointers.leetcode;

public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }

    private static int strStr(String haystack, String needle) {

        for (int i = 0; ; i++)
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i+j)!=needle.charAt(j)) break;
            }


//        We can use this way as well :
//        -----------------------------
//        int i = 0, j = 0;
//
//        while (true) {
//            while (true) {
//                if (j == needle.length()) return i;
//                if (i + j == haystack.length()) return -1;
//                if (haystack.charAt(i+j)!=needle.charAt(j)) break;
//                j++;
//            }
//            i++;
//            j = 0;
//        }

    }
}