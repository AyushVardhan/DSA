package com.Geeksforgeeks.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kthInTwoSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int[] ints = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int m = ints[0], n = ints[1], k = ints[2];
            int[] A = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] B = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int[] tmp = new int[m + n];
            int i = 0, j = 0, a = 0;
            while (i < m && j < n) {
                if (A[i] < B[j]) {
                    tmp[a] = A[i++];
                    a = a + 1;
                } else if (B[j] < A[i]) {
                    tmp[a] = B[j++];
                    a = a + 1;
                } else {
                    tmp[a] = A[i++];
                    a = a + 1;
                    tmp[a] = B[j++];
                    a = a + 1;
                }
            }

            while (i < m){
                tmp[a++] = A[i++];
            }

            while (j < n){
                tmp[a++] = B[j++];
            }

            System.out.println(tmp[k-1]);
        }
    }
}
