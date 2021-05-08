package com.Leetcode.twopointer;

public class IsLongestPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alexd", "ale"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int j = 0, i =0;
        for (; i < name.length(); i++) {

            char chrAtName = name.charAt(i);
            int cntCharAtName = 1;

            if (j > typed.length()-1 || chrAtName != typed.charAt(j)) {
                return false;
            }

            while (i + 1 < name.length() && chrAtName == name.charAt(i + 1)) {
                cntCharAtName++;
                i++;
            }

            for (; j < typed.length() && chrAtName == typed.charAt(j); j++) {

                int cntCharAtTyped = 1;
                while (j + 1 < typed.length() && typed.charAt(j) == typed.charAt(j + 1)) {
                    cntCharAtTyped++;
                    j++;
                }

                if (cntCharAtName > cntCharAtTyped)
                    return false;
            }


        }

        while (j < typed.length()) {
            if (name.charAt(i-1) != typed.charAt(j))
                return false;
            j++;
        }

        return true;
    }
}
