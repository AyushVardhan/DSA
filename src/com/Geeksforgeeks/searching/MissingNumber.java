package com.Geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(br.readLine().trim());
        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;

            for (int i = 0; i < n-1; i++) {
                sum = sum + arr[i];
            }

            int totSum = (n * (n + 1)) / 2;
            System.out.println(totSum-sum);
        }
    }
}
