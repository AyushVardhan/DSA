package com.leetcode.array;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,0};
        int target = -100;
        System.out.println(threeSumClosest(arr, target));;
    }

    private static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, minSum = 0, tmp = 0, sum = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= n - 2; i++) {
            int l = i + 1, h = n - 1;
            while (l < h){
                sum = nums[i] + nums[l] + nums[h];
                tmp = Math.abs(target - sum);
                if (tmp < diff){
                    diff = tmp;
                    minSum = sum;
                }

                if (sum == target) break;
                else if (sum > target) h--;
                else l++;
            }
        }

        return minSum;
    }
}
