package com.Geeksforgeeks.binarysearchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberOfUniqueBsts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[50];

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Arrays.fill(arr, 0);

            arr[0] = 1;
            arr[1] = 1;

            for (int i = 2; i <= n; i++)
                for (int j = 1; j <= i; j++)
                    arr[i] += arr[i - j] * arr[j - 1];

            System.out.println(arr[n]);
        }
    }
}
