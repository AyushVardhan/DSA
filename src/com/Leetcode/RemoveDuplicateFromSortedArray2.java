package com.Leetcode;

public class RemoveDuplicateFromSortedArray2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 1, 1, 1, 3, 3, 3}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        if (nums.length == 3)
            if (nums[0] == nums[2])
                return 2;
            else return 3;
        else {
            int i = 0, j, k, n = nums.length;
            while (i < n) {
                if (i + 2 < n && nums[i] == nums[i + 2]) {
                    k = i + 2;
                    j = k;
                    i = k;
                    while (k < n && nums[k] == nums[j])
                        k++;
                    while (k < n) {
                        nums[j] = nums[k];
                        k++;
                        j++;
                    }
                    n = n - (k - j);
                } else {
                    i++;
                }
            }
            return n;
        }
    }
}
