package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){

            int j = i;
            while (j + 1 < nums.length && nums[j]+1 == nums[j+1]){
                j++;
            }

            if (j == i){
                list.add(String.valueOf(nums[i]));
            }else {
                list.add(nums[i] +"->"+nums[j]);
                i = j;
            }
        }

        return list;
    }
}
