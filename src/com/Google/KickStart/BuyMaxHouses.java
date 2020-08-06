package com.Google.KickStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        for (int j = 1; j <= t; j++){
            String[] s = read.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            String st[] = read.readLine().trim().split("\\s+");

            int A[] = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st[i]);
            }

            Arrays.sort(A);
            int count = 0, sum = 0;
            for (int i = 0; i < A.length; i++){
                if (sum + A[i] <= m){
                    sum = sum + A[i];
                    count++;
                }
            }

            System.out.println("Case #"+j+": " + count);
        }
    }
}
