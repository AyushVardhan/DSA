package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class FirstElementOccuringNtimes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine().trim());

        while (test-- > 0){
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] a = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            int k = arr[1];

            HashMap<Integer, Integer> map = new HashMap<>();

            for (Integer num : a) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            int flag = 0;
            for (Integer num : a) {
                if (map.get(num) == k) {
                    flag = num;
                    break;
                }
            }

            System.out.println(flag != 0 ? flag : -1);
        }
    }
}
