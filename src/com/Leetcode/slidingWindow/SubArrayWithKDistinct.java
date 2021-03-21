package com.Leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinct {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{2, 1, 2, 1, 6}, 2));
    }

    private static int atMostK(int arr[], int n, int k)
    {
        int count = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < n) {

            map.put(arr[right],
                    map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0)
                    map.remove(arr[left]);
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }

    private static int subarraysWithKDistinct(int arr[], int k)
    {
        int length = arr.length;
        return (atMostK(arr, length, k)
                - atMostK(arr, length, k - 1));
    }
}
