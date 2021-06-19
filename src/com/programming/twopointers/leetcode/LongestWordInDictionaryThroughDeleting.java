package com.programming.twopointers.leetcode;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }

    public static String findLongestWord(String s, List< String > d) {

        String maxStr = "";

        for (String str : d) {
            if (isSubString(str, s)) {
                if (str.length() > maxStr.length() || (str.length() == maxStr.length() && str.compareTo(maxStr) < 0))
                    maxStr = str;
            }
        }

        return maxStr;
    }

    private static boolean isSubString(String dStr, String iStr) {
        int j = 0;
        for (int i = 0; j < dStr.length() && i < iStr.length(); i++) {
            if (dStr.charAt(j) == iStr.charAt(i))
                j++;
        }

        return j == dStr.length();
    }
}
