package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchInRotatedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(br.readLine().trim());

            System.out.println(getIndex(arr, n, k));
        }
    }

    private static int getIndex(int[] arr, int n, int k) {
        int l = 0, h = n - 1, mid;

        while (l <= h) {
            mid = (int) Math.ceil((l + h) / 2);
            if (arr[mid] == k) {
                return mid;
            }

            if (arr[l] <= arr[mid]) {
                if (arr[mid] >= k && arr[l] <= k) {
                    h = mid-1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (arr[h] >= k && arr[mid] <= k) {
                    l = mid + 1;
                } else {
                    h = mid-1;
                }
            }
        }

        return -1;
    }
}
