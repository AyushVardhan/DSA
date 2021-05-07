package com.Leetcode.twopointer;

public class LongestMountainInArray {
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{1,2,3,4}));
    }

    public static int longestMountain(int[] arr) {
        int res = 0, start, j;
        boolean up=false,down=false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                start = i - 1;
                j = i-1;

                while ((start + 1) < arr.length && arr[start] < arr[start + 1]) {
                    start++;
                    up = true;
                }

                while ((start + 1) < arr.length && arr[start] > arr[start + 1]) {
                    start++;
                    down = true;
                }

                if (up && down) {
                    res = Math.max(res, start - j + 1);
                }
                i = start;
                up = false;
                down = false;
            }
        }

        return res;
    }
}
