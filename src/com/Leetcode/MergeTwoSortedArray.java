package com.Leetcode;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        mergeWithoutExtraSpace(nums1, 3, nums2, 3);
    }

    private static void mergeWithoutExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        int lastNum1 = m - 1;
        int lastNum2 = n - 1;

        for (int i = (n + m - 1); i >= 0; i--) {
            if (lastNum2 < 0)
                break;

            if (lastNum1 >= 0 && nums1[lastNum1] > nums2[lastNum2]){
                nums1[i] = nums1[lastNum1];
                lastNum1--;
            }else {
                nums1[i] = nums2[lastNum2];
                lastNum2--;
            }
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {


        int tmp[] = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m & j < n) {
            if (nums1[i] < nums2[j]) {
                tmp[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                tmp[k++] = nums2[j++];
            } else {
                tmp[k++] = nums1[i++];
                tmp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            tmp[k++] = nums1[i++];
        }

        while (j < n) {
            tmp[k++] = nums2[j++];
        }

        System.arraycopy(tmp, 0, nums1, 0, tmp.length);
        System.out.println("Hi");
    }
}
