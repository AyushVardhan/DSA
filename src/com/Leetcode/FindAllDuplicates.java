package com.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7}));
    }

    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] < 0) {
                list.add(idx);
            } else {
                nums[idx - 1] = -nums[idx - 1];
            }
        }

        return list;
    }
}


/*  Approach One

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int data : nums){
            if (set.contains(data)){
                list.add(data);
            }

            set.add(data);
        }

        return list;

 */

/*  Approach Two

        int length = nums.length;

        if (length <= 0)
            return new ArrayList<>();

        for (int i = 0; i < length; i++){
            int index = (nums[i] - 1) % length;
            nums[index] =  nums[index] + length;
        }

        int duplicateFactor = length * 2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > duplicateFactor)
                list.add(i+1);
        }

        return list;

 */