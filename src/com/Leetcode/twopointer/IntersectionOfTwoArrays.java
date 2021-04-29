package com.Leetcode.twopointer;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectWithRepeat(new int[]{1,2,2,1}, new int[]{2,2})));
    }

    private static int[] intersectWithRepeat(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }

        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }

        if (map1.size() > map2.size()) {
            return getIntersectWithRepeat(map2,map1);
        } else {
            return getIntersectWithRepeat(map1,map2);
        }
    }

    private static int[] getIntersectWithRepeat(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {

        List<Integer> list = new ArrayList<>();

        for (int num : map1.keySet()){
            if (map2.containsKey(num)){
                int countInMap1 = map1.get(num);
                int countInMap2 = map2.get(num);

                int cnt = Math.min(countInMap1, countInMap2);
                for (int i = 0; i < cnt; i++) {
                    list.add(num);
                }
            }
        }

        int[] ret = new int[list.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private static int[] intersectWithoutRepeat(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        if (set1.size() > set2.size()) {
            return getIntersect(set2,set1);
        } else {
            return getIntersect(set1,set2);
        }
    }

    private static int[] getIntersect(Set<Integer> set1, Set<Integer> set2) {
        int[] res = new int[set1.size()];
        int a = 0;
        for (int num1 : set1) {
            if (set2.contains(num1)) {
                res[a++] = num1;
            }
        }

        return Arrays.copyOf(res, a);
    }
}
