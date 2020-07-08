package com.Geeksforgeeks.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class NonRepeatingElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while (tests-- > 0){
            long size = Long.parseLong(br.readLine().trim());
            long[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            HashMap<Long,Long> map = new HashMap<>();

            for (Long num : arr){
                if (map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }else {
                    map.put(num,(long)1);
                }
            }

            long flag = 0;
            for (Long num : arr){
                if (map.get(num)==1){
                    flag = num;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}
