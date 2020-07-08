package com.Geeksforgeeks.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PaintersPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int[] a = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int k = a[0], n = a[1];

            int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(minTime(arr, n, k));
        }
    }

    private static int minTime(int[] a, int n, int k) {
        int sum = 0;
        for (Integer s : a) {
            sum += s;
        }

        int low = 0;
        int high = sum;
        int mid = 0;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            mid = (low + high) / 2;
            if (validPartition(a, n, k, mid)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean validPartition(int[] a, int n, int k, int mid) {
        int worker = 1, currSum = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] > mid) return false;
            if (currSum + a[i] > mid) {
                worker++;
                currSum = a[i];
                if (worker > k) return false;
            } else {
                currSum += a[i];
            }
        }

        return true;
    }
}
