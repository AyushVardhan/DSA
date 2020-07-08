package com.Leetcode;

public class NextPermutation {
    public static void main(String[] args) {
        int arr[] = new int[]{6,7,5};
        nextPermutation(arr);
        for (int s : arr)
            System.out.println(s);
    }

    private static void nextPermutation(int[] nums) {
        int n = nums.length, p = -1, q = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                p = i - 1;
                break;
            }
        }

        if (p == -1) {
            reverse(nums,0,n-1);
            return;
        }

        for (int i = n - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }

        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
        reverse(nums,p+1,n-1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            i++;
            j--;
        }
    }
}
