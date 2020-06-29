package com.leetcode.array;

public class MinJumps {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,1,1,4};
        System.out.println(canJump(arr));
    }

    private static boolean canJump(int[] nums) {
        int res = minJ_Dynamic(nums, nums.length);
        return res != Integer.MAX_VALUE;
    }

    private static int minJump(int[] arr, int l, int h) {
        if (l == h) return 0;
        if (arr[l] == 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= (l + arr[l]); i++) {
            int jmps = minJump(arr,i,h);
            if (jmps!=Integer.MAX_VALUE && min > jmps + 1){
                min = jmps + 1;
            }
        }

        return min;
    }

    private static int minJ_Dynamic(int[] arr, int n){
        int[] jumps = new int[n];
        int min;

        jumps[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] == 0)
                jumps[i] = Integer.MAX_VALUE;
            else if (arr[i] >= n - i - 1)
                jumps[i] = 1;

            else {
                min = Integer.MAX_VALUE;

                for (int j = i + 1; j < n && j <= arr[i] + i; j++) {
                    if (min > jumps[j])
                        min = jumps[j];
                }

                if (min != Integer.MAX_VALUE)
                    jumps[i] = min + 1;
                else
                    jumps[i] = min;
            }
        }

        return jumps[0];
    }
}
