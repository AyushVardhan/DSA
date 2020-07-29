package com.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int prev = map.get(nums[i]);
                if (i - prev <= k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
