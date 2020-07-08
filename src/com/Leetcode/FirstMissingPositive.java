package com.Leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int arr[] = new int[]{0};
        System.out.println(firstMissingPositive(arr));
    }

    private static int firstMissingPositive(int[] nums) {
        int i = 0, k = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] <= 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        if (i != 0) {
            for (int j = i; j < n; j++) {
                int tmp = nums[k];
                nums[k] = nums[j];
                nums[j] = tmp;
                k++;
            }
            n = k;
        }

        for (int j = 0; j < n; j++) {
            int x = Math.abs(nums[j]);
            if (x - 1 < n && nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] > 0) {
                return j + 1;
            }
        }
        return n + 1;
    }
}
