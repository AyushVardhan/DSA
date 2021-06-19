package com.programming.twopointers.leetcode;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    private static boolean backspaceCompare(String s, String t) {
        int n1 = s.length() - 1;
        int n2 = t.length() - 1;

        while (n1 >= 0 || n2 >= 0) {
            int idx1 = getNextValidIndex(s, n1);
            int idx2 = getNextValidIndex(t, n2);

            if (idx1 < 0 && idx2 < 0)
                return true;

            if (idx1 < 0 || idx2 < 0)
                return false;

            if (s.charAt(idx1) != t.charAt(idx2))
                return false;

            n1 = idx1 - 1;
            n2 = idx2 - 1;
        }

        return true;
    }

    private static int getNextValidIndex(String s, int idx) {
        int backSpaceCount = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                backSpaceCount++;
            } else if (backSpaceCount > 0) {
                backSpaceCount--;
            } else break;

            idx--;
        }

        return idx;
    }
}
