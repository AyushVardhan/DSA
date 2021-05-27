package com.twopointers.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(atMostK(new int[]{1, 2, 1, 2, 3}, 2));
    }

    private static int atMostK(int arr[], int k) {
        int n = arr.length;
        return subArrayWithAtMostKDistinct(arr, n, k) - subArrayWithAtMostKDistinct(arr, n, k-1);
    }

    private static int subArrayWithAtMostKDistinct(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0, l = 0;

        for (int r = 0; r < n; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0)
                    map.remove(arr[l]);

                l++;
            }

            cnt += (r-l+1);
        }

        return cnt;
    }
}
