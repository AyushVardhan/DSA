package com.twopointers.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    private static int threeSumClosest(int[] arr, int target) {

        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1, r = arr.length - 1;

            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];

                if (Math.abs(diff) > Math.abs(target - sum)) {
                    diff = target-sum;
                    res = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target)
                    l++;
                else
                    r--;
            }
        }

        return res;
    }

}
