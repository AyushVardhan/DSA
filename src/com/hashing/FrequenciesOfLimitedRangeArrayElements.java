package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FrequenciesOfLimitedRangeArrayElements {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a1 = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < n ; i++){
                a1[i] = a1[i]-1;
            }

            for (int i = 0; i < n; i++) {
                a1[a1[i] % n] = a1[a1[i] % n] + n;
            }

            StringBuilder str = new StringBuilder();
            for (Integer num : a1){
                str.append(num/n).append(" ");
            }

            System.out.println(str);
        }
    }
}
