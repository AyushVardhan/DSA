package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class ElectionWinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] ar = br.readLine().trim().split(" ");

            TreeMap<String, Integer> map = new TreeMap<>();
            int maxCount = 0;
            for (String str : ar) {
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }

                if (map.get(str) > maxCount) {
                    maxCount = map.get(str);
                }
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    break;
                }
            }
        }
    }
}
