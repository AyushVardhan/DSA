package com.algorithms.sorting;

import java.util.Arrays;

public class SortingBasedOnThreshold {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 2, 3, 1})));
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int QUICK_THRESHOLD = 50;
        int MERGE_THRESHOLD = 300;

        if (nums.length < QUICK_THRESHOLD) {
            return selectionSort(nums);
        } else if (nums.length < MERGE_THRESHOLD) {
            quickSort(nums, 0 , nums.length-1);
            return nums;
        } else {
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, mid+1, right);
    }

    private static void merge(int[] nums, int leftLo, int leftHi, int rightLo, int rightHi) {
        if (leftLo == rightHi)
            return;

        int left = leftLo;
        int[] tmpArr = new int[leftHi - leftLo + 1 + rightHi - rightLo + 1];
        int idx = 0;

        while (leftLo <= leftHi && rightLo <= rightHi){
            tmpArr[idx++] = (nums[leftLo] < nums[rightLo]) ? nums[leftLo++] : nums[rightLo++];
        }

        while (leftLo <= leftHi){
            tmpArr[idx++] = nums[leftLo++];
        }

        while (rightLo <= rightHi) {
            tmpArr[idx++] = nums[rightLo++];
        }

        idx = 0;
        while (left <= rightHi) {
            nums[left++] = tmpArr[idx++];
        }
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivot = partition(nums, left, right);
        quickSort(nums,left, pivot-1);
        quickSort(nums, pivot+1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int expectedPivotIndex = left - 1;

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                expectedPivotIndex++;
                swapArrElement(nums, i, expectedPivotIndex);
            }
        }

        swapArrElement(nums, expectedPivotIndex + 1, right);
        return expectedPivotIndex + 1;
    }

    private static int[] selectionSort(int[] nums) {
        for (int currIdx = 0; currIdx < nums.length-1; currIdx++){
            int minIdx = currIdx;
            for (int itr = currIdx + 1; itr < nums.length; itr++) {
                if (nums[itr] < nums[minIdx]) {
                    minIdx = itr;
                }
            }
            swapArrElement(nums, currIdx, minIdx);
        }

        return nums;
    }

    private static void swapArrElement(int[] nums, int currIdx, int minIdx) {
        if (currIdx == minIdx)
            return;

        nums[currIdx] ^= nums[minIdx];
        nums[minIdx] ^= nums[currIdx];
        nums[currIdx] ^= nums[minIdx];
    }
}
