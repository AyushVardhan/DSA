package com.Leetcode;

import java.util.*;

public class ThreeSums {
    public static void main(String[] args) {
        int arr[] = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return lst;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == -nums[i]) {
                    List<Integer> lst_tmp = new ArrayList<Integer>();
                    lst_tmp.add(nums[i]);
                    lst_tmp.add(nums[l]);
                    lst_tmp.add(nums[r]);
                    lst.add(lst_tmp);
                    while (l < nums.length && l < r && nums[l + 1] == nums[l])
                        l++;
                    while (r > i && l < r && nums[r - 1] == nums[r])
                        r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < -nums[i]) {
                    while (l < nums.length && l < r && nums[l + 1] == nums[l])
                        l++;
                    l++;
                } else {
                    while (r > i && l < r && nums[r - 1] == nums[r])
                        r--;
                    r--;
                }
            }
        }
        return lst;
    }

    private static List<List<Integer>> threeSumMap(int[] nums) {
        Set<List<Integer>> lst = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<>(lst);
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = nums.length - 1, sum = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int k = l; k <= r; k++) {
                int diff = sum - nums[k];
                if (map.containsKey(diff)) {
                    List<Integer> lst_tmp= new ArrayList<>();
                    lst_tmp.add(nums[i]);
                    lst_tmp.add(nums[k]);
                    lst_tmp.add(nums[map.get(diff)]);
                    lst.add(lst_tmp);
                } else {
                    map.put(nums[k], k);
                }
            }

        }
        return new ArrayList<>(lst);
    }
}
