package com.twopointers.leetcode;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int l1 = m - 1;
        int l2 = n - 1;
        int i = length;

        for (; i >= 0 && l1 >= 0 && l2 >= 0; i--) {
            if (nums1[l1] < nums2[l2]) {
                nums1[i] = nums2[l2--];
            } else {
                nums1[i] = nums1[l1--];
            }
        }

        while (l1 >= 0 && i >= 0) {
            nums1[i--] = nums1[l1--];
        }

        while (l2 >= 0 && i >= 0) {
            nums1[i--] = nums2[l2--];
        }
        

//        *** ANOTHER WAY ***
//
//
//        int len = n + m -1;
//        int len1 = m - 1;
//        int len2 = n - 1;
//
//        for (int i = len; i >= 0; i--) {
//            if (len2 < 0) {
//                break;
//            }
//
//            if (len1 >= 0 && nums1[len1] > nums2[len2]){
//                nums1[i] = nums1[len1];
//                len1--;
//            } else {
//                nums1[i] = nums2[len2];
//                len2--;
//            }
//        }
    }
}
