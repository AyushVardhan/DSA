package com.programming.twopointers.leetcode;

public class RemoveDuplicateFromSortedArrayII {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 2}));
    }

    private static int removeDuplicates(int[] nums) {

        if (nums.length < 3)
            return nums.length;

        if (nums.length == 3) {
            if (nums[0] == nums[2])
                return 2;
            else return 3;
        } else {

            int n = nums.length;
            int i = 0, k = 0, j = 0;

            while (i < n) {
                if (i + 2 < n && nums[i] == nums[i + 2]) {
                    k = i + 2;
                    j = k;
                    i = k;
                    while (k < n && nums[k] == nums[j])
                        k++;
                    while (k < n) {
                        nums[j] = nums[k];
                        j++;
                        k++;
                    }
                    n = n - (k - j);
                } else i++;
            }
            return n;
        }
    }

}
