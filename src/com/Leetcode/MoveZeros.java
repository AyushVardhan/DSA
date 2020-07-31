package com.Leetcode;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void moveZeroes(int[] nums) {
        if (nums.length <= 0)
            return;

        int i, j = 0;
        for (i = 0; i < nums.length && j < nums.length; i++) {
            if (nums[i] == 0) {
                if (nums[j] != 0)
                    j = i;
                continue;
            }

            if (nums[j] != 0){
                continue;
            }

            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            while (j < nums.length && nums[j] != 0){
                j++;
            }
        }
    }
}


/* ANOTHER APPROACH: nice & clean:

		int zeroIndex=-1;

        for(int i=0;i<nums.length;i++){
            if (nums[i] != 0 && zeroIndex >=0 )
            {
                nums[zeroIndex]=nums[i];
                nums[i]=0;

                if (nums[zeroIndex+1]==0)
                    zeroIndex++;
                else
                    zeroIndex=i;
            }
            else if(nums[i] == 0 && zeroIndex == -1)
            {
                zeroIndex = i;
            }
        }

 */