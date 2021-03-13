package com.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here
        int prod = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                break;
            }

            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    subarrays.add(Arrays.asList(arr[i]));
                    prod = arr[i];
                } else {
                    prod *= arr[j];
                    if (prod < target) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = i ; k <= j; k++) {
                            list.add(arr[k]);
                        }
                        subarrays.add(list);
                    } else {
                        break;
                    }
                }
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
