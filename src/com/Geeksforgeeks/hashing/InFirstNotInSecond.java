package com.Geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class InFirstNotInSecond {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long tests = Long.parseLong(br.readLine().trim());

        while (tests-- > 0) {
            long[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            long n1 = arr[0], n2 = arr[1];
            long[] a1 = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] a2 = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();

            HashSet<Long> set = new HashSet<>();
            for (Long num : a2) {
                set.add(num);
            }

            StringBuilder str = new StringBuilder();
            for (Long num : a1){
                if (!set.contains(num)){
                    str.append(num).append(" ");
                }
            }

            System.out.println(str);
        }
    }
}