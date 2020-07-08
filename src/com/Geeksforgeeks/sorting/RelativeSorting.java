package com.Geeksforgeeks.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n1 = array[0];
            int n2 = array[1];

            int[] ar1 = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] ar2 = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (Integer n : ar1) {
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }

            StringBuilder str = new StringBuilder();
            for (Integer n : ar2) {
                if (map.containsKey(n)) {
                    for (int i = 0; i < map.get(n); i++) {
                        str.append(n).append(" ");
                    }
                    map.remove(n);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int n = entry.getKey();
                for (int i = 0; i < entry.getValue(); i++) {
                    str.append(n).append(" ");
                }
            }

            System.out.println(str);
        }
    }
}
