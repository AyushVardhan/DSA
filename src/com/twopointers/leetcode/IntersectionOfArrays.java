package com.twopointers.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            while (i+1 < nums1.length && nums1[i] == nums1[i+1]) {
                i++;
            }

            while (j+1 < nums2.length && nums2[j] == nums2[j+1]) {
                j++;
            }

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[list.size()]; int k = 0;
        for(int data : list) {
            res[k++] = data;
        }

        return res;
    }
}
