package com.string;

public class AllPermutationOfString {
    public static void main(String[] args) {
        generateAllPermutation("ABC", 0, 2);
    }

    private static void generateAllPermutation(String s, int l, int r) {
        if (l == r)
            System.out.println(s);
        else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                generateAllPermutation(s, l+1, r);
                s = swap(s, l, i);
            }
        }
    }

    private static String swap(String s, int l, int i) {
        char[] chars = s.toCharArray();
        char tmp = chars[l];
        chars[l] = chars[i];
        chars[i] = tmp;

        return String.valueOf(chars);
    }
}
