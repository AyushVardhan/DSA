package com.programming.challange.leetcode.may21;

public class MaxValueAfterInsertion {
    public static void main(String[] args) {
        System.out.println(maxValue("99", 9));
    }

    private static String maxValue(String n, int x) {
        char[] chrs = n.toCharArray();
        if (chrs[0] == '-') { // handle negative case
            String str = n.substring(1);

            char[] newChrs = str.toCharArray();
            int i = 0;
            for (; i < newChrs.length; i++) {
                if (Character.getNumericValue(newChrs[i]) > x) {
                    break;
                }
            }

            return "-" + str.substring(0,i) + x + (i != str.length() ? str.substring(i) : "");

        } else {
            int i = 0;
            for (; i < chrs.length; i++) {
                if (Character.getNumericValue(chrs[i]) < x) {
                    break;
                }
            }

            return n.substring(0,i) + x + (i != n.length() ? n.substring(i) : "");
        }
    }
}
