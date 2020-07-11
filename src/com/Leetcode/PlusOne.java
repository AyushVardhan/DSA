package com.Leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    private static int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        while (digits[index] == 9) {
            digits[index] = 0;
            index--;

            if (index == -1) {
                int[] tmp = new int[digits.length + 1];
                tmp[0] = 1;
                for (int i = 1; i < tmp.length; i++){
                    tmp[i] = digits[i-1];
                }

                return tmp;
            }
        }

        digits[index] += 1;
        return digits;
    }
}
