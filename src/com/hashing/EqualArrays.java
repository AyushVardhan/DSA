package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class EqualArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long[] a1 = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] a2 = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();

            HashMap<Long, Long> map = new HashMap<>();

            for (Long num : a1) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, (long) 1);
                }
            }


            for (Long num : a2) {
                if (map.containsKey(num))
                    map.remove(num);
            }

            System.out.println(map.size() == 0 ? 1 : 0);
        }
    }
}
