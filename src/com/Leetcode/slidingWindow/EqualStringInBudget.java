package com.Leetcode.slidingWindow;

public class EqualStringInBudget {
    public static void main(String[] args) {
        System.out.println(equalSubstring("krrgw","zjxss", 19));
    }

    public static int equalSubstring(String s, String t, int k) {
        int i = 0, j =0;
        for (; j < s.length(); j++) {
            k = k - Math.abs(s.charAt(j) - t.charAt(j));
            if (k < 0){
                k += Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
        }

        return j - i;
    }
}
