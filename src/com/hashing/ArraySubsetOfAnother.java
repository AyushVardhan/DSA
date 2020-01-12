package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySubsetOfAnother {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int[] tmp = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n1 = tmp[0];
            int n2 = tmp[1];
            int[] a1 = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] a2 = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            Set<Integer> set = new HashSet<>();
            for (Integer num : a1) {
                set.add(num);
            }

            int count = 0;
            for (Integer num : a2) {
                if (set.contains(num)) {
                    count++;
                }
            }

            System.out.println(count == n2 ? "Yes" : "No");
        }
    }
}
