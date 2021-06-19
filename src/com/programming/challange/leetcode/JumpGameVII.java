package com.programming.challange.leetcode;

public class JumpGameVII {

    public static void main(String[] args) {
        System.out.println(canReach("0000000000", 1, 1));
    }

    static private int minJump;
    static private int maxJump;

    public static boolean canReach(String s, int min, int max) {
        if (s.charAt(0) != '0' || s.charAt(s.length() - 1) != '0')
            return false;

        minJump = min;
        maxJump = max;

        return canReachDest(s.toCharArray(), new int[s.length()], minJump, maxJump);
    }

    private static boolean canReachDest(char[] s, int[] mem, int min, int max) {
        if (min <= s.length - 1 && max >= s.length - 1)
            return true;

        if (min > s.length - 1)
            return false;

        for (int i = min; i <= max; i++) {
            if (mem[i] != 0)
                return mem[i] == 1;
            if (s[i] == '0') {
                boolean next = canReachDest(s, mem, i + minJump, i + maxJump);
                mem[i] = next ? 1 : -1;
                if (next)
                    return true;
            }
        }

        return false;
    }
}
