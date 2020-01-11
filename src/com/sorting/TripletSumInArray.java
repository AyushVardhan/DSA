package com.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSumInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int size = ar[0];
            int find = ar[1];

            int[] ar1 = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(ar1);
            System.out.println(tripletPossible(size, find, ar1) ? 1 : 0);
        }
    }

    private static boolean tripletPossible(int size, int find, int[] ar1) {
        int l,r;
        for (int i = 0; i < size - 2; i++) {
            l = i + 1;
            r = size - 1;
            while (l < r) {
                int sum = ar1[i] + ar1[l] + ar1[r];
                if (sum == find) {
                    return true;
                } else if (sum > find) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return false;
    }
}
