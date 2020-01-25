package com.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocateMinimumPages {
    static boolean isPossible(int arr[], int n, int m, int curMin) {
        int studentsRequired = 1;
        int curSum = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] > curMin) return false;

            if (curSum + arr[i] > curMin) {

                studentsRequired++;
                curSum = arr[i];
                if (studentsRequired > m) return false;
            } else {
                curSum += arr[i];
            }
        }
        return true;
    }

    static int solve(int A[], int n, int m) {

        long sum = 0;
        if (n < m) return -1;

        for (int i = 0; i < n; ++i)
            sum += A[i];


        long start = 0;
        long end = sum, mid = 0;
        int ans = Integer.MAX_VALUE;

        while (start <= end) {

            mid = (start + end) / 2;

            if (isPossible(A, n, m, (int) mid) == true) {

                ans = Math.min(ans, (int) mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;

    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int A[] = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st[i]);
            }
            int m = Integer.parseInt(read.readLine());
            System.out.println(solve(A, n, m));

        }
    }
}