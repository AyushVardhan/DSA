package com.challange.leetcode.may21;

public class WordEqualSummationOfWord {
    public static void main(String[] args) {
        System.out.println(isSumEqual("aaa", "a", "aa"));
    }

    private static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getNumericalValue(firstWord);
        int second = getNumericalValue(secondWord);
        int target = getNumericalValue(targetWord);

        return first + second == target;
    }

    private static int getNumericalValue(String word) {
        int cur, num = 0;
        for (char c : word.toCharArray()) {
            cur = c - 'a';
            num = num * 10 + cur;
        }

        return num;
    }
}
