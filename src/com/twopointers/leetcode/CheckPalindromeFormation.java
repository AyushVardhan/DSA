package com.twopointers.leetcode;

public class CheckPalindromeFormation {
    public static void main(String[] args) {
        System.out.println(checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }

    private static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private static boolean check(String a, String b) {
        for (int i = 0, j = a.length() - 1; i < j; i++, j--) {
            if (a.charAt(i) != b.charAt(j))
                return isPa(a, i, j) || isPa(b, i, j);
        }

        return true;
    }

    private static boolean isPa(String a, int i, int j) {
        for (; i < j; i++,j--) {
            if (a.charAt(i) != a.charAt(j))
                return false;
        }

        return true;
    }


//    Brute Force
//    private static boolean checkPalindromeFormation(String a, String b) {
//        if (isPalindrome(a) || isPalindrome(b))
//            return true;
//
//        int n = a.length();
//        for (int i = 0; i < n; i++) {
//            String aPre = a.substring(0, i);
//            String aSuf = a.substring(i, n);
//            String bPre = b.substring(0, i);
//            String bSuf = b.substring(i, n);
//
//            if (isPalindrome(aPre + bSuf) || isPalindrome(bPre + aSuf))
//                return true;
//        }
//
//        return false;
//    }
//
//    private static boolean isPalindrome(String s) {
//        if (s.length() <= 1)
//            return true;
//
//        int l = 0, r = s.length() - 1;
//        while (l < r) {
//            if (s.charAt(l) != s.charAt(r)) {
//                return false;
//            }
//            l++;
//            r--;
//        }
//
//        return true;
//    }
}
