package com.Leetcode.twopointer;

public class SplitTwoStringToMakePalindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("abdef","fecab"));
    }

    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private static boolean isPa(String s, int i, int j) {
        for (; i < j; ++i, --j)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    private static boolean check(String a, String b) {
        for (int i = 0, j = a.length() - 1; i < j; ++i, --j)
            if (a.charAt(i) != b.charAt(j))
                return isPa(a, i, j) || isPa(b, i, j);
        return true;
    }
}