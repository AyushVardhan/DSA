package com.Geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KeyPair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());
        while (tests-- > 0){
            int[] s = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] ar = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            int k = s[1];
            Arrays.sort(ar);

            int l = 0, h = n - 1, flag = 0;
            while (l < h) {
                int sum = ar[l] + ar[h];
                if (sum == k) {
                    flag = 1;
                    break;
                } else if (sum < k) {
                    l++;
                } else {
                    h--;
                }
            }

            System.out.println(flag == 0 ? "No" : "Yes");
        }
    }
}
