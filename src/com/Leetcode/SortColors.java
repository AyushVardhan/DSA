package com.Leetcode;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        for (int a : nums) {
            System.out.print(a + " ");
        }
    }

    private static void sortColors(int[] nums) {
        if (nums.length <= 0)
            return;

        int i = 0, k = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
            } else if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                k++;
                i++;
            } else {
                i++;
            }
        }
    }
}
